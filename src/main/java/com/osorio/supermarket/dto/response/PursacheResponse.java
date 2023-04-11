package com.osorio.supermarket.dto.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PursacheResponse {

    @Id
    private int pursacheId;
    private String namePursache;
    private int valor;

}
