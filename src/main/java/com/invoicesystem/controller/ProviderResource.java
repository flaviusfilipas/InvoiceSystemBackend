package com.invoicesystem.controller;

import com.invoicesystem.domain.Provider;
import com.invoicesystem.dto.ProviderDTO;
import com.invoicesystem.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/provider")
@CrossOrigin
public class ProviderResource {
    private ProviderService providerService;

    public ProviderResource(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderDTO providerDTO) throws URISyntaxException {
        if (providerDTO.getId() != null) {
            return ResponseEntity.badRequest()
                    .build();
        }
        ProviderDTO savedProvider = providerService.save(providerDTO);
        return ResponseEntity.created(new URI("/api/v1/provider/ " + savedProvider.getId()))
                .build();
    }

    @PutMapping
    public ResponseEntity<ProviderDTO> updateProvider(@RequestBody ProviderDTO providerDTO) {
        if (providerDTO.getId() == null) {
            return ResponseEntity.badRequest()
                    .build();
        }
        ProviderDTO savedProvider = providerService.save(providerDTO);
        return ResponseEntity.ok(savedProvider);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Provider>> findAll() {
        log.info("REST request to find all providers");
        List<Provider> all = providerService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/admin/all")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<Provider>> findAdminAll() {
        log.info("REST request to find all providers");
        List<Provider> all = providerService.findAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Provider> findOneById(@PathVariable Integer id) {
        log.info("REST request to find all providers");
        Provider provider = providerService.findOne(id);
        return ResponseEntity.ok(provider);
    }
}
