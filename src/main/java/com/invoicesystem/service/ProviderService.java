package com.invoicesystem.service;

import com.invoicesystem.domain.Provider;
import com.invoicesystem.dto.ProviderDTO;
import com.invoicesystem.mapper.ProviderMapper;
import com.invoicesystem.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    private final ProviderMapper providerMapper;

    public ProviderService(ProviderRepository providerRepository,
                           ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }

    public ProviderDTO save(ProviderDTO providerDTO) {
        Provider provider = providerMapper.toEntity(providerDTO);
        Provider savedProvider = providerRepository.save(provider);
        return providerMapper.toDto(savedProvider);
    }

    public Provider findOne(Integer id) {
        return providerRepository.getOne(id);
    }

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }


    public Optional<ProviderDTO> findById(Integer id) {
        return providerRepository.findById(id)
                .map(providerMapper::toDto);
    }


}
