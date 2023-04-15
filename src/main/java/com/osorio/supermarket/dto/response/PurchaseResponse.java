package com.osorio.supermarket.dto.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseResponse {

    @Id
    private int pursacheId;
    private String namePursache;
    private int valor;

}
