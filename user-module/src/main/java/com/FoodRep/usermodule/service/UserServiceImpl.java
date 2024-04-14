package com.FoodRep.usermodule.service;

import com.FoodRep.usermodule.dto.UserDTO;
import com.FoodRep.usermodule.repository.UserRepository;
import com.FoodRep.usermodule.utils.EntityDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private  final UserRepository userRepository;
    public Mono<UserDTO> createUser(Mono<UserDTO> userDTO) {
        return userDTO.map(EntityDtoUtils::users)
                .flatMap(userRepository::save)
                .map(EntityDtoUtils::toDto);
    }

    @Override
    public Mono<UserDTO> updateUser(Integer id, Mono<UserDTO> userDTO) {
        return userRepository.findById(id)
                .flatMap(u -> userDTO
                        .map(EntityDtoUtils::users)
                        .doOnNext(e -> e.setId(id))
                        .flatMap(userRepository::save)
                        .map(EntityDtoUtils::toDto)
                );
    }

    @Override
    public Mono<Void> deleteUser(Integer id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Flux<UserDTO> getAllUser() {
        return userRepository.findAll()
                .map(EntityDtoUtils::toDto);
    }

    @Override
    public Mono<UserDTO> getUser(final int id) {
        return userRepository.findById(id)
                .map(EntityDtoUtils::toDto);
    }
}
