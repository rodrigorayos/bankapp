package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequest {
    private String name;
    private String lastname;
    private String ci;
    private String mobile;
    private String address;
    private String status;
}
