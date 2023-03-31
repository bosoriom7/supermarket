package com.osorio.supermarket.controller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//Anotaciones:
@Entity
@Table(name = "Products")
@Data
public class Product {

    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotNull
    @NotBlank(message = "Nombre es requerido")
    private String name;

    private int quantity;
}