package com.osorio.supermarket.controller;
import com.osorio.supermarket.dto.request.PurchaseRequest;
import com.osorio.supermarket.dto.response.PurchaseResponse;
import com.osorio.supermarket.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@RequestMapping("/purchases")
@RestController
public class PurchaseController {

    //Inyectando el servicio al controller
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {this.purchaseService = purchaseService;}

    @GetMapping
    public ResponseEntity<List<PurchaseResponse>>getAllPurchases(){
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

/*    @GetMapping("/{pursache-id}")
    public ResponseEntity<Optional<PursacheResponse>>getPursacheById(@PathVariable ("pursache-id")int pursacheId){
        return new ResponseEntity<>(purchaseService.getPursacheById(pursacheId),HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<PurchaseResponse>savePurchase(@RequestBody @Valid PurchaseRequest purchaseRequest){
        return new ResponseEntity<>(purchaseService.savePurchase(purchaseRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{purchase-id}")
    public ResponseEntity<Void> deletePurchaseById(@PathVariable("purchase-id") int pursacheId){
        purchaseService.deletePurchaseById(pursacheId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{purchase-id}")
    public ResponseEntity<PurchaseResponse>updatePurchaseById(@RequestBody @Valid PurchaseRequest purchaseRequest){
        return new ResponseEntity<>(purchaseService.updatePurchaseById(purchaseRequest), HttpStatus.OK);
    }

    @GetMapping("/{purchase-id}")
    public ResponseEntity<Optional<String>>getColorById(@PathVariable ("purchase-id")int pursacheId){
        return new ResponseEntity<>(purchaseService.getColorById(pursacheId),HttpStatus.OK);
    }

    @GetMapping("/by-color/{color}")
    public ResponseEntity<Optional<PurchaseResponse>>getPurchaseByColor(@PathVariable ("color")String color){
        return new ResponseEntity<>(purchaseService.findByColor(color),HttpStatus.OK);
    }
}