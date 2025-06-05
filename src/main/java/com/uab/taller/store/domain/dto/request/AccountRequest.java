package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    private Double balance;
    private String currencyType;
    private Long userId;
}