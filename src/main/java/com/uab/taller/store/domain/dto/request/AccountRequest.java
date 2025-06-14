package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    private String currencyType;
    private String type;
    private Double balance;
    private String status;
    private Long userId;
}
