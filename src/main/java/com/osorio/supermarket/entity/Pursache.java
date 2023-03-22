package com.osorio.supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Anotaciones:
@Entity
@Table(name = "Pursaches")
@Data
public class Pursache {

    @Id
    @GeneratedValue
    private int userId;
    private int pursachetId;

}