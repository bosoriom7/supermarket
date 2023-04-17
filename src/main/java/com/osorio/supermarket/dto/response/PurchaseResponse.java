package com.osorio.supermarket.dto.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseResponse {

    @Id
    private int purchaseId;
    private String namePurchase;
    private int valor;

}
