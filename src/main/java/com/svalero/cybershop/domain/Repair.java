package com.svalero.cybershop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(max = 20)
    @NotNull
    @NotBlank
    private String component;

    @Column
    @NotNull
    @Positive
    private float price;

    @Column
    @Size(max = 500)
    private String shippingAddress;

    @Column
    private LocalDate shipmentDate;

    @Column
    @PastOrPresent
    private LocalDate repairedDate;



}
