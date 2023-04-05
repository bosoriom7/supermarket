package com.osorio.supermarket.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String password;
}
