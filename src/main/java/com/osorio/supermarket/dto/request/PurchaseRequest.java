package com.osorio.supermarket.dto.request;

import lombok.Data;
@Data
public class PurchaseRequest {

    private int pursacheId = 0;
    private String namePursache;
    private int valor;
    private String color;

}
