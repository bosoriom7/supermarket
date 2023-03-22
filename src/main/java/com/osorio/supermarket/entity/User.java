package com.osorio.supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Anotaciones
@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue
    private String name;
    private String lastName;
    private int age;
}