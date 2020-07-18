package com.invoicesystem.repository;

import com.invoicesystem.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}
