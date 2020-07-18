package com.invoicesystem.controller;

import com.invoicesystem.domain.Provider;
import com.invoicesystem.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
