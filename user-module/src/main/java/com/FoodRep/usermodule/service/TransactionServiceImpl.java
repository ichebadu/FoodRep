package com.FoodRep.usermodule.service;

import com.FoodRep.usermodule.dto.TransactionRequestDTO;
import com.FoodRep.usermodule.dto.TransactionResponseDTO;
import com.FoodRep.usermodule.enums.TransactionStatus;
import com.FoodRep.usermodule.repository.TransactionRepository;
import com.FoodRep.usermodule.utils.EntityDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository transactionRepository;

    @Override
    public Mono<TransactionResponseDTO> createTransaction(final TransactionRequestDTO transactionRequestDTO){
        return transactionRepository.updateUserBalance(transactionRequestDTO.getId(), transactionRequestDTO.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDtoUtils.TransactionRequestDTOtoTransactionEntity(transactionRequestDTO))
                .flatMap(transactionRepository::save)
                .map(transform -> EntityDtoUtils.TransactionRequestDTOToTransactionResponse(transactionRequestDTO, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtils.TransactionRequestDTOToTransactionResponse(transactionRequestDTO,TransactionStatus.DECLINE));
    }
}
