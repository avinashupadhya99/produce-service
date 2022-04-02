package com.production.produce.repository;

import java.util.Optional;

import com.production.produce.model.Produce;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduceRepository extends CrudRepository<Produce, Long> {
    Optional<Produce> findById(Long id);
}
