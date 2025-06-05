package com.uab.taller.store.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Random;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String accountNumber;
    Double balance;
    String currencyType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @PrePersist
    public void generateAccountNumber() {
        if (this.accountNumber == null) {
            String prefix = "10001";
            int randomPart = new Random().nextInt(90000) + 10000;
            this.accountNumber = prefix + randomPart;
        }
    }
}