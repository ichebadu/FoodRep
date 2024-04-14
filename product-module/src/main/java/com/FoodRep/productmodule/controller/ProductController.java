package com.FoodRep.productmodule.controller;

import com.FoodRep.productmodule.dto.ProductDTo;
import com.FoodRep.productmodule.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("all")
    public Flux<ProductDTo> getAllProduct(){
        return productService.getAll();
    }
    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDTo>> getProductById(@PathVariable("id") String id){
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
               .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @GetMapping("price")
    public Flux<ProductDTo> getProductByPriceRange(
            @RequestParam("min") int min,
            @RequestParam("max") int max){
        return productService.getProductByPriceRange(min,max);
    }
    @PostMapping
    public Mono<ProductDTo> insertProduct(@RequestBody Mono<ProductDTo> productDToMono){
        return productService.insertProduct(productDToMono);
    }
    @PutMapping("{id}")
    public Mono<ResponseEntity<ProductDTo>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDTo> productDTo){
        return productService.updateProduct(id,productDTo)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.delete(id);
    }

}
