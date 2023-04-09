package com.osorio.supermarket.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private int productId;
    private String name;
    private int quantity;
    private double priceSelf;
}
