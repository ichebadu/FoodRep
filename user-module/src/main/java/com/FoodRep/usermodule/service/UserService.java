package com.FoodRep.usermodule.service;

import com.FoodRep.usermodule.dto.UserDTO;
import com.FoodRep.usermodule.entity.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDTO> createUser(Mono<UserDTO> userDTOMono);
    Mono<UserDTO> updateUser(Integer id,Mono<UserDTO> userDTO);
    Mono<Void> deleteUser(Integer id);
    Flux<UserDTO> getAllUser();
    Mono<UserDTO> getUser(final int id);
}
