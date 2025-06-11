package com.uab.taller.store.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private Long accountId;
    private String number;
    private String currencyType;
    private String type;
    private Double balance;
    private String status;
    private Long userId;
}
