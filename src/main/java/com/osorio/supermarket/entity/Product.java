package com.osorio.supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Anotaciones:
@Entity
@Table(name = "Products")
@Data
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    private String name;

    private int quantity;
}