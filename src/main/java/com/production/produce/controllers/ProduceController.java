package com.production.produce.controllers;

import com.production.produce.model.Produce;
import com.production.produce.repository.ProduceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.opentracing.Span;
import io.opentracing.util.GlobalTracer;

@RestController
@RequestMapping("/api/v1/produce")
public class ProduceController {
    @Autowired
    ProduceRepository produceRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProduceController.class);

    @RequestMapping(value = "/new", 
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produce> createOrder(@RequestBody Produce produce) {
        final Span span = GlobalTracer.get().activeSpan();
        if (span != null) {
            span.setTag("order_id", produce.getOrderId());
        }
        Produce newProduce = produceRepository.save(produce);
        logger.info("New produce created with ProduceID - {} and OrderID - {}", newProduce.getId(), newProduce.getOrderId());
        return new ResponseEntity<>(newProduce, HttpStatus.OK);
    }
}
