package com.osorio.supermarket.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PursacheRequest {
    private String namePursache;
    private int valor;
    private String color;

}
