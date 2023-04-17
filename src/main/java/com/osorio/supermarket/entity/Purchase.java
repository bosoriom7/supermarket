package com.osorio.supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Anotaciones:
@Entity
@Table(name = "pursaches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue
    private int purchaseId;

    @NotNull
    @NotBlank(message = "Nombre es requerido")
    private String namePurchase;
    private int valor;
    private String color;
}