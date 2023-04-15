package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.PurchaseRequest;
import com.osorio.supermarket.dto.response.PurchaseResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    public List <PurchaseResponse> getAllPursaches();

    //public Optional<PursacheResponse> getPursacheById(int pursacheId);

    public PurchaseResponse savePursache(@Valid PurchaseRequest purchaseRequest);

    public PurchaseResponse updatePursacheById(PurchaseRequest purchaseRequest);

    public void deletePursacheById(int pursacheID);

    public Optional<String>getColorById(int pursacheId);

    public Optional<PurchaseResponse> findByColor(String Color);
}
