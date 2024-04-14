package com.FoodRep.usermodule.utils;

import com.FoodRep.usermodule.dto.TransactionRequestDTO;
import com.FoodRep.usermodule.dto.TransactionResponseDTO;
import com.FoodRep.usermodule.dto.UserDTO;
import com.FoodRep.usermodule.entity.Transaction;
import com.FoodRep.usermodule.entity.Users;
import com.FoodRep.usermodule.enums.TransactionStatus;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;


public class EntityDtoUtils {
    public static UserDTO toDto(Users users){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userDTO.getName());
        userDTO.setBalance(userDTO.getBalance());
        return userDTO;
    }

    public static  Users users(UserDTO userDTO){
        Users users = new Users();
        BeanUtils.copyProperties(userDTO,users);
        return users;
    }

    public  static Transaction TransactionRequestDTOtoTransactionEntity(TransactionRequestDTO transactionRequestDTO){
        Transaction transaction = new Transaction();
        transaction.setUserId(transaction.getUserId());
        transaction.setAmount(transaction.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        BeanUtils.copyProperties(transactionRequestDTO, transaction);
        return transaction;
    }
    public static TransactionResponseDTO TransactionRequestDTOToTransactionResponse(TransactionRequestDTO transactionRequestDTO, TransactionStatus transactionStatus){
        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
        transactionResponseDTO.setId(transactionRequestDTO.getId());
        transactionResponseDTO.setAmount(transactionRequestDTO.getAmount());
        transactionResponseDTO.setStatus(transactionStatus);
        return transactionResponseDTO;

    }
}
