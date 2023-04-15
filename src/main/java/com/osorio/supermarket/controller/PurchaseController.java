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

@RequestMapping("/pursaches")
@RestController
public class PurchaseController {

    //Inyectando el servicio al controller
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {this.purchaseService = purchaseService;}

    @GetMapping
    public ResponseEntity<List<PurchaseResponse>>getAllPursache(){
        return new ResponseEntity<>(purchaseService.getAllPursaches(), HttpStatus.OK);
    }

/*    @GetMapping("/{pursache-id}")
    public ResponseEntity<Optional<PursacheResponse>>getPursacheById(@PathVariable ("pursache-id")int pursacheId){
        return new ResponseEntity<>(purchaseService.getPursacheById(pursacheId),HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<PurchaseResponse>savePursache(@RequestBody @Valid PurchaseRequest purchaseRequest){
        return new ResponseEntity<>(purchaseService.savePursache(purchaseRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{pursache-id}")
    public ResponseEntity<Void> deletePursacheById(@PathVariable("pursache-id") int pursacheId){
        purchaseService.deletePursacheById(pursacheId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{pursache-id}")
    public ResponseEntity<PurchaseResponse>updatePursacheById(@RequestBody @Valid PurchaseRequest purchaseRequest){
        return new ResponseEntity<>(purchaseService.updatePursacheById(purchaseRequest), HttpStatus.OK);
    }

    @GetMapping("/{pursache-id}")
    public ResponseEntity<Optional<String>>getColorById(@PathVariable ("pursache-id")int pursacheId){
        return new ResponseEntity<>(purchaseService.getColorById(pursacheId),HttpStatus.OK);
    }

    @GetMapping("/by-color/{color}")
    public ResponseEntity<Optional<PurchaseResponse>>getPurchaseByColor(@PathVariable ("color")String color){
        return new ResponseEntity<>(purchaseService.findByColor(color),HttpStatus.OK);
    }
}