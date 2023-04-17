package com.example.springbootaws.controllers;

import com.example.springbootaws.db.entities.UserEntity;
import com.example.springbootaws.models.UserDTO;
import com.example.springbootaws.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Morris.Okworo on 11/04/2023
 */
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}
