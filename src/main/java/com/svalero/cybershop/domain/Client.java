package com.svalero.cybershop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "client")
public class Client {

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
       @PositiveOrZero
       private int number;

       @Column
       @PastOrPresent
       private LocalDate registerDate;

       @Column
       private boolean vip;


}
