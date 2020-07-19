package com.invoicesystem.dto;

import lombok.Data;
@Data
public abstract class IdentityDTO {
    private Integer id;
    private String name;
    private String registrationNumber;
    private String cif;
    private String account;
    private String bank;
    private String headquarters;
}
