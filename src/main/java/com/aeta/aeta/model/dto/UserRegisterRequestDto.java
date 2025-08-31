package com.aeta.aeta.model.dto;

import lombok.Data;

@Data
public class UserRegisterRequestDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
