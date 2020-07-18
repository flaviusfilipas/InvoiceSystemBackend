package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "invoice")
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "monetary_unit")
    private String monetaryUnit;
    @Column(name = "net_amount")
    private Double netAmount;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "vat_value")
    private Double vatValue;
    @ManyToOne
    private ProviderServiceName providerService;
    @OneToOne
    private ExpeditionData expeditionData;
}
