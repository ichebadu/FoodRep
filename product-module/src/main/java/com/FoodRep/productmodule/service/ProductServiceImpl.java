package com.FoodRep.productmodule.service;

import com.FoodRep.productmodule.dto.ProductDTo;
import com.FoodRep.productmodule.repository.ProductRepository;
import com.FoodRep.productmodule.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Flux<ProductDTo> getAll(){
        return productRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }
    @Override
    public Mono<ProductDTo> getProductById(String id){
        return productRepository.findById(id)
                .map(EntityDtoUtil::toDto);
    }
    @Override
    public Flux<ProductDTo> getProductByPriceRange(int min, int max){
        return productRepository.findByPriceBetween(Range.closed(min,max))
                .map(EntityDtoUtil::toDto);
    }

    @Override
    public Mono<ProductDTo> insertProduct(Mono<ProductDTo> productDToMono){
        return productDToMono.map(EntityDtoUtil::productEntity)
                .flatMap(this.productRepository::insert)
                .map(EntityDtoUtil::toDto);
    }
    @Override
    public Mono<ProductDTo> updateProduct(String id, Mono<ProductDTo> productDToMono){
        return productRepository.findById(id)
                .flatMap(p -> productDToMono
                        .map(EntityDtoUtil::productEntity)
                        .doOnNext(e -> e.setId(id))
                        .flatMap(productRepository::save)
                        .map(EntityDtoUtil::toDto));
    }

    @Override
    public Mono<Void> delete(String id){
        return productRepository.deleteById(id);
    }

}
