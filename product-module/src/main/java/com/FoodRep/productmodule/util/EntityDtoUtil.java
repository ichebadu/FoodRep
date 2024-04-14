package com.FoodRep.productmodule.util;

import com.FoodRep.productmodule.dto.ProductDTo;
import com.FoodRep.productmodule.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static ProductDTo toDto(Product product){
        ProductDTo dTo = new ProductDTo();
        BeanUtils.copyProperties(product, dTo);
        return dTo;
    }
    public static Product productEntity(ProductDTo productDTo){
        Product product= new Product();
        BeanUtils.copyProperties(productDTo, product);
        return product;
    }
}
