package com.svalero.cybershop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    @NotBlank
    private String name;

    @Column
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String type;

    @Column
    @NotNull
    @Positive
    private float price;

    @Column
    private String origin;

    @Column
    private boolean inStock;

}
