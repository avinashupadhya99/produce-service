package com.production.produce.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="production_produce")
public class Produce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "OrderID is mandatory")
    private Long orderId;
    @NotNull(message = "Produce Quantity is mandatory")
    private Long quantity;
    @NotBlank(message = "Produce Product is mandatory")
    private String product;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
