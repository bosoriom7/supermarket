package com.osorio.supermarket.controller;
import com.osorio.supermarket.dto.request.PursacheRequest;
import com.osorio.supermarket.dto.response.PursacheResponse;
import com.osorio.supermarket.entity.Pursache;
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
public class PursacheController {

    //Inyectando el servicio al controller
    private final PurchaseService purchaseService;

    public PursacheController(PurchaseService purchaseService) {this.purchaseService = purchaseService;}

    @GetMapping
    public ResponseEntity<List<PursacheResponse>>getAllPursache(){
        return new ResponseEntity<>(purchaseService.getAllPursaches(), HttpStatus.OK);
    }

/*    @GetMapping("/{pursache-id}")
    public ResponseEntity<Optional<PursacheResponse>>getPursacheById(@PathVariable ("pursache-id")int pursacheId){
        return new ResponseEntity<>(purchaseService.getPursacheById(pursacheId),HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<PursacheResponse>savePursache(@RequestBody @Valid PursacheRequest pursacheRequest){
        return new ResponseEntity<>(purchaseService.savePursache(pursacheRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{pursache-id}")
    public ResponseEntity<Void> deletePursacheById(@PathVariable("pursache-id") int pursacheId){
        System.out.println(pursacheId);
        purchaseService.deletePursacheById(pursacheId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{pursache-id}")
    public ResponseEntity<PursacheResponse>updatePursacheById(@RequestBody @Valid PursacheRequest pursacheRequest){
        return new ResponseEntity<>(purchaseService.updatePursacheById(pursacheRequest), HttpStatus.OK);
    }

    @GetMapping("/{pursache-id}")
    public ResponseEntity<Optional<String>>getColorById(@PathVariable ("pursache-id")int pursacheId){
        return new ResponseEntity<>(purchaseService.getColorById(pursacheId),HttpStatus.OK);
    }
}