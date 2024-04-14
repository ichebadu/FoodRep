package com.FoodRep.usermodule.controller;

import com.FoodRep.usermodule.dto.UserDTO;
import com.FoodRep.usermodule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("user")
    public Mono<UserDTO> createUser(@RequestBody Mono<UserDTO> userDTO){
        return this.userService.createUser(userDTO);
    }
    @PutMapping("user/{id}")
    public Mono<UserDTO> updateUser(@PathVariable("id") Integer id,@RequestBody Mono<UserDTO> userDTO){
        return this.userService.updateUser(id,userDTO);
    }
    @GetMapping("user/{id}")
    public Mono<UserDTO> getUser(@PathVariable("id")Integer id){
        return this.userService.getUser(id);
    }
    @GetMapping("users")
    public Flux<UserDTO> getAllUser(){
        return this.userService.getAllUser();
    }
    @DeleteMapping("user/{id}")
    public Mono<Void> deleteUser(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }
}
