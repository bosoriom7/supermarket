package com.osorio.supermarket.controller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//Anotaciones
@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue
    private int userId;

    @NotNull(message = "Campo requerido")
    private String name;


    private String lastName;
    private int age;



}