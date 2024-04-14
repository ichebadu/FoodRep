package com.FoodRep.usermodule.controller;

import com.FoodRep.usermodule.dto.TransactionRequestDTO;
import com.FoodRep.usermodule.dto.TransactionResponseDTO;
import com.FoodRep.usermodule.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("transaction")
    public Mono<TransactionResponseDTO> createTransaction(@RequestBody Mono<TransactionRequestDTO> transactionRequestDTOMono) {
        return transactionRequestDTOMono.flatMap(transactionService::createTransaction);
    }
}

