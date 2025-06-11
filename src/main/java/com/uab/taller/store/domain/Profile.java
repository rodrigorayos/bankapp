package com.uab.taller.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addDate;
    private String addUser;
    private String changeDate;
    private String changeUser;
    private Boolean deleted;

    private String name;
    private String lastName;
    private String gender;
    private String ci;
    private String mobile;
    private String address;
    private String status;

    @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private User user;

}
