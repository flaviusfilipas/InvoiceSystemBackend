package com.invoicesystem.mapper;

import com.invoicesystem.domain.Provider;
import com.invoicesystem.dto.ProviderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    @Mapping(source = "user.id",target = "userId")
    ProviderDTO toDto(Provider provider);

    @Mapping(source = "userId",target = "user.id")
    Provider toEntity(ProviderDTO providerDTO);
}
