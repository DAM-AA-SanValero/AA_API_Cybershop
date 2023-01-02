package com.svalero.cybershop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "techician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank
    @NotNull
    private String name;

    @Column
    @NotBlank
    @NotNull
    private String surname;

    @Column
    @Size(max=9)
    @PositiveOrZero
    private int mobileNumber;

    @Column
    private String department;

    @Column
    private boolean isAvailable;




}
