package com.uab.taller.store.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResponse {
    private Long profileId;
    private String name;
    private String lastname;
    private String ci;
    private String mobile;
    private String address;
    private String status;
}
