package com.FoodRep.productmodule.util;

import com.FoodRep.productmodule.dto.ProductDTo;
import com.FoodRep.productmodule.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DataSetupService implements CommandLineRunner {

    private final ProductService productService;
    @Override
    public void run(String... args) throws Exception {
        ProductDTo p1 = new ProductDTo("nokia",456);
        ProductDTo p2 = new ProductDTo("Samsung", 7000);
        ProductDTo p3 = new ProductDTo("laptop", 5000);

        Flux.just(p1,p2,p3)
                .flatMap(data -> productService.insertProduct(Mono.just(data)))
                .subscribe(System.out::println);
    }
}
