package com.example.springbootaws.services;

import com.example.springbootaws.db.entities.UserEntity;
import com.example.springbootaws.db.repository.UserRepository;
import com.example.springbootaws.models.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Morris.Okworo on 11/04/2023
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity addUser(UserDTO user) {
        UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .phone(user.getPhone())
                .lastName(user.getLastName())
                .physicalAddress(user.getPhysicalAddress())
                .build();
        return userRepository.save(userEntity);
    }

    public UserEntity getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("User Not Found"));
        return user;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
