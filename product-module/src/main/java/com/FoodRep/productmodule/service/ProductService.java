package com.FoodRep.productmodule.service;

import com.FoodRep.productmodule.dto.ProductDTo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDTo> getAll();

    Mono<ProductDTo> getProductById(String id);

    Flux<ProductDTo>getProductByPriceRange(int min, int max);

    Mono<ProductDTo> insertProduct(Mono<ProductDTo> productDToMono);

    Mono<ProductDTo> updateProduct(String id, Mono<ProductDTo> productDToMono);

    Mono<Void> delete(String id);
}
