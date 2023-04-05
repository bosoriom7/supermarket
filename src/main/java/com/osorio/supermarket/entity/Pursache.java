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
@Table(name = "Pursaches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pursache {

    @Id
    @GeneratedValue
    private int pursacheId;

    @NotNull
    @NotBlank(message = "Nombre es requerido")
    private String namePursache;
    private int valor;
    private String color;
}