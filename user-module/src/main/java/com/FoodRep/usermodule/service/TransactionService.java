package com.FoodRep.usermodule.service;

import com.FoodRep.usermodule.dto.TransactionRequestDTO;
import com.FoodRep.usermodule.dto.TransactionResponseDTO;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<TransactionResponseDTO> createTransaction(TransactionRequestDTO transactionRequestDTO);
}
