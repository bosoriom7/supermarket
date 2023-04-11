package com.osorio.supermarket.dto.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PursacheRequest {

    @Id
    private int pursacheId;

    private String namePursache;
    private int valor;
    private String color;

}
