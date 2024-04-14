package com.FoodRep.usermodule.repository;

import com.FoodRep.usermodule.entity.Transaction;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Integer> {
    @Modifying
    @Query("UPDATE users " +
            "SET balance = balance - :amount " +
            "WHERE id = :userId " +
            "AND balance >= :amount"
    )
    Mono<Boolean> updateUserBalance(int userId, int amount);

}
