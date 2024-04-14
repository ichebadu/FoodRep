package com.FoodRep.productmodule.dto;

import lombok.Data;

@Data
public class ProductDTo {
    private String id;
    private String description;
    private Integer price;

    public ProductDTo( String description, Integer price) {
        this.description = description;
        this.price = price;
    }

    public ProductDTo() {
    }
}
