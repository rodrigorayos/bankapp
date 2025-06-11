package com.uab.taller.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String currencyType; // Moneda: USD, BOB, etc.
    private String type;         // Tipo: Ahorro, Corriente, etc.
    private Double balance;
    private String status;       // Activo/Inactivo

    private String addDate;
    private String addUser;
    private String changeDate;
    private String changeUser;
    private Boolean deleted;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}