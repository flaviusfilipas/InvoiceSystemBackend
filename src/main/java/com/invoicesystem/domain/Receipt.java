package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "receipt")
@Entity
public class Receipt {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "receipt_number")
    private Long receiptNumber;
    @OneToOne
    private Invoice invoice;
}
