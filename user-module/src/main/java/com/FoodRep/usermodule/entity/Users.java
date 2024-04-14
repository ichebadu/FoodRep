package com.FoodRep.usermodule.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "users")
public class Users {
    @Id
    private Integer id;
    private String name;
    private Integer balance;
}
