package com.uab.taller.store.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "target_account_id", nullable = true)
    private Account targetAccount;

    private String transactionType; // Retiro, Depósito, Transferencia
    private Double amount;
    private LocalDate date;
}
