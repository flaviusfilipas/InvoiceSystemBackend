package com.invoicesystem.service;

import com.invoicesystem.UserAlreadyExistsException;
import com.invoicesystem.domain.User;
import com.invoicesystem.dto.UserDTO;
import com.invoicesystem.mapper.UserMapper;
import com.invoicesystem.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {

    private static final String ROLE_USER = "ROLE_USER";

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find user by username: " + username));


        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                Stream.of(new SimpleGrantedAuthority(user.getRole())).collect(Collectors.toList()));
    }

    public UserDTO register(UserDTO userDTO) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User with provided username already exists");
        }
        userDTO.setRole(ROLE_USER);
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }
}
