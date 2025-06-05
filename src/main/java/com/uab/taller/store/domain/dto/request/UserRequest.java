package com.uab.taller.store.domain.dto.request;

import com.uab.taller.store.domain.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {
    String email;
    String password;
    List<Account> accounts;
}
