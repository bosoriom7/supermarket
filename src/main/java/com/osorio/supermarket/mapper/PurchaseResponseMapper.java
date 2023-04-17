package com.osorio.supermarket.mapper;

import com.osorio.supermarket.dto.response.PurchaseResponse;
import com.osorio.supermarket.entity.Purchase;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PurchaseResponseMapper implements Function<Purchase, PurchaseResponse> {
    @Override
    public PurchaseResponse apply(Purchase purchase) {
        return new PurchaseResponse(purchase.getPurchaseId(), purchase.getNamePurchase(), purchase.getValor());
    }
}
