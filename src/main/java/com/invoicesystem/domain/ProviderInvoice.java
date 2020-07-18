package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "provider_invoice")
@Entity
public class ProviderInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Provider provider;
    @ManyToOne
    private Invoice invoice;
}
