package com.svalero.cybershop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank
    @NotNull
    private String productDiscount;

    @Column
    @Size(max = 500)
    @NotBlank
    @NotNull
    private String event;

    @Column
    @Negative
    private float discountDifference;

    @Column
    private LocalDate startDiscount;

    @Column
    private LocalDate endDiscount;


}
