package com.osorio.supermarket.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
    private int productId = 0;

    @NotNull
    @NotBlank(message = "Nombre es requerido")
    private String name;

    @Min(value = 1, message = "rango permitido desde 1 hasta 100")
    @Max(value = 100, message = "rango permitido desde 1 hasta 100")
    private int quantity;
    
    private double pricePurchase;
}
