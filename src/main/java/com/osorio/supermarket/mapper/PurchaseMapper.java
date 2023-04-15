package com.osorio.supermarket.mapper;

import com.osorio.supermarket.dto.request.PurchaseRequest;
import com.osorio.supermarket.entity.Purchase;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PurchaseMapper implements Function<PurchaseRequest, Purchase> {

    @Override
    public Purchase apply(PurchaseRequest purchaseRequest) {
        return new Purchase(purchaseRequest.getPursacheId(), purchaseRequest.getNamePursache(), purchaseRequest.getValor(), purchaseRequest.getColor());
    }
}
