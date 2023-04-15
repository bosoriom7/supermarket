package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.PurchaseRequest;
import com.osorio.supermarket.dto.response.PurchaseResponse;
import com.osorio.supermarket.entity.Purchase;
import com.osorio.supermarket.mapper.PurchaseMapper;
import com.osorio.supermarket.mapper.PurchaseResponseMapper;
import com.osorio.supermarket.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService{


    private String ERROR_PURSACHE = "Id de pursache no encontrado";
    //Inyectando el repositorio en el servicio
    //Se declara final cuando no nos interesa crear clases derivadas de dicha clase
    private final PurchaseRepository purchaseRepository;

    private final PurchaseMapper purchaseMapper;

    private final PurchaseResponseMapper purchaseResponseMapper;

    //Constructor
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper, PurchaseResponseMapper purchaseResponseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }

    //Sobrescribiendo los métodos
    @Override
    public List<PurchaseResponse> getAllPursaches(){
        return purchaseRepository.findAll().stream().map(purchaseResponseMapper).toList();}

    @Override
    public void deletePursacheById(int pursacheId){
        Optional<Purchase> pursache = purchaseRepository.findById(pursacheId);
        if (pursache.isPresent()) {
            purchaseRepository.deleteById(pursacheId);
        }
    }

    @Override
    public Optional<String>getColorById(int pursacheId){
        return purchaseRepository.findById(pursacheId)
                .map(pursache->pursache.getColor())
                .or(()->{throw new IllegalArgumentException(ERROR_PURSACHE);});
    }

    @Override
    public Optional<PurchaseResponse> findByColor(String color) {
        //Optional<Purchase> pursacheByColor =
        return Optional.ofNullable(purchaseRepository.findByColor(color)
                .map(purchaseResponseMapper)
                .orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public PurchaseResponse updatePursacheById(PurchaseRequest purchaseRequest){
        Purchase purchase = purchaseMapper.apply(purchaseRequest);
        return purchaseRepository.findById(purchase.getPursacheId())
                .map(existingPursache -> purchaseRepository.save(purchase))
                .map(purchaseResponseMapper)
                .orElseThrow(()-> new IllegalArgumentException(ERROR_PURSACHE));
    }

/*    @Override
    public Optional <PursacheResponse> getPursacheById(int pursacheId){
        return pursacheRepository.findById(pursacheId)
                .map(pursacheResponseMapper)
                .or(()->{throw new IllegalArgumentException(ERROR_PURSACHE);});
    }*/


    @Override
    public PurchaseResponse savePursache(PurchaseRequest purchaseRequest) {
        Purchase purchase = purchaseMapper.apply(purchaseRequest);
        Purchase savePurchase = purchaseRepository.save(purchase);
        return purchaseResponseMapper.apply(savePurchase);
     }

}
