package com.invoicesystem.controller;

import com.invoicesystem.domain.Provider;
import com.invoicesystem.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProviderResource {
    private ProviderService providerService;

    public ProviderResource(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/provider/all")
    public ResponseEntity<List<Provider>> findAll() {
        log.info("REST request to find all providers");
        List<Provider> all = providerService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/provider/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Provider> findOneById(@PathVariable Integer id) {
        log.info("REST request to find all providers");
        Provider provider = providerService.findOne(id);
        return ResponseEntity.ok(provider);
    }
}
