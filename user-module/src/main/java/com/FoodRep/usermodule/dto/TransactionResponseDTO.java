package com.FoodRep.usermodule.dto;

import com.FoodRep.usermodule.enums.TransactionStatus;
import lombok.Data;

@Data
public class TransactionResponseDTO {
    private Integer id;
    private Integer amount;
    private TransactionStatus status;
}
