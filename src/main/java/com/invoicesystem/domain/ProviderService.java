package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="provider_service")
@Entity
public class ProviderService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="service_name")
    private String serviceName;
}
