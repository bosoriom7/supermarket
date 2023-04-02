package com.osorio.supermarket.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private int quantity;
    private double pricePurchase;
}
