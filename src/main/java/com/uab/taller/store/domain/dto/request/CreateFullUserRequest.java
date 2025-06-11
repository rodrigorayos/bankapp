package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateFullUserRequest {
    String name;
    String lastName;
    LocalDate birthDate;
    String gender;
    String email;
    String password;
    private String roleName;

}
