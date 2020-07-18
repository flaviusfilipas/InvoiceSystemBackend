package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "provider")
@Entity
public class Provider extends Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="series",nullable = false)
    private String series;
    @Column(name="phone_number",length = 12)
    private String phoneNumber;
    @Column(name = "cssvn")
    private String cssvn;
    @Column(name = "vat_percent")
    private Integer vatPercent;
}
