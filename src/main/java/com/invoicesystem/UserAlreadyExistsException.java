package com.invoicesystem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserAlreadyExistsException extends Exception {
    private String message;
}
