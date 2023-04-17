package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.PurchaseRequest;
import com.osorio.supermarket.dto.response.PurchaseResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    public List <PurchaseResponse> getAllPurchases();

    public PurchaseResponse savePurchase(@Valid PurchaseRequest purchaseRequest);

    public PurchaseResponse updatePurchaseById(PurchaseRequest purchaseRequest);

    public void deletePurchaseById(int purchaseID);

    public Optional<String>getColorById(int purchaseID);

    public Optional<PurchaseResponse> findByColor(String Color);
}
