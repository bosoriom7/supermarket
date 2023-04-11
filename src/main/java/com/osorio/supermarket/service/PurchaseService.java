package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.PursacheRequest;
import com.osorio.supermarket.dto.response.PursacheResponse;
import com.osorio.supermarket.entity.Pursache;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    public List <PursacheResponse> getAllPursaches();

    //public Optional<PursacheResponse> getPursacheById(int pursacheId);

    public PursacheResponse savePursache(@Valid PursacheRequest pursacheRequest);

    public PursacheResponse updatePursacheById(PursacheRequest pursacheRequest);

    public void deletePursacheById(int pursacheID);

    public Optional<String>getColorById(int pursacheId);
}
