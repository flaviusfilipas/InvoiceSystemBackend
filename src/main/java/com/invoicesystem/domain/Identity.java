package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Identity {
    @Column(name = "name")
    private String name;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "cif")
    private String cif;
    @Column(name = "account")
    private String account;
    @Column(name = "bank")
    private String bank;
    @Column(name="headquarters")
    private String headquarters;
}
