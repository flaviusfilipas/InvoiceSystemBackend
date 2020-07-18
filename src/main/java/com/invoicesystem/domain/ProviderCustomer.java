package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "provider_customer")
@Entity
public class ProviderCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Provider provider;
    @ManyToOne
    private Customer customer;
}
