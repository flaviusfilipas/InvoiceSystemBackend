package com.invoicesystem.controller;

import com.invoicesystem.UserAlreadyExistsException;
import com.invoicesystem.dto.UserDTO;
import com.invoicesystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    //TODO refactor
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDTO userDTO) {
        try {
            userService.register(userDTO);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }

        return ResponseEntity.noContent().build();
    }
}
