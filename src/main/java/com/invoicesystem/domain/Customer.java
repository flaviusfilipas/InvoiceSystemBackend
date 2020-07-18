package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customer")
@Entity
public class Customer extends Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
