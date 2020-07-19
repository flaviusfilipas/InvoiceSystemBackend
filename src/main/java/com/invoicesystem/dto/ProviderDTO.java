package com.invoicesystem.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ProviderDTO extends IdentityDTO{

    private String series;
    @Size(max = 12)
    private String phoneNumber;
    private String cssvn;
    private Integer vatPercent;
    private Integer userId;
}
