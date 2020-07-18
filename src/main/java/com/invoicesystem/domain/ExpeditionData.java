package com.invoicesystem.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "expedition_data")
@Entity
public class ExpeditionData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "delegate_name")
    private String delegateName;
    @Column(name = "personal_id_info")
    private String personalIdInfo;
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @Column(name = "expedition_date")
    private LocalDate expeditionDate;
}
