package com.invoicesystem.service;

import com.invoicesystem.domain.Provider;
import com.invoicesystem.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }

    public Provider save(Provider provider){
        return providerRepository.save(provider);
    }

    public Provider findOne(Integer id){
        return providerRepository.getOne(id);
    }

    public List<Provider> findAll(){
        return providerRepository.findAll();
    }


}
