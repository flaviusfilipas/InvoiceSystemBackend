package com.invoicesystem.mapper;

import com.invoicesystem.domain.User;
import com.invoicesystem.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
