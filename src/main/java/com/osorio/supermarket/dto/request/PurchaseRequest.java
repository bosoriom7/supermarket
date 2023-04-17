package com.osorio.supermarket.dto.request;

import lombok.Data;
@Data
public class PurchaseRequest {

    private int purchaseId = 0;
    private String namePurchase;
    private int valor;
    private String color;

}
