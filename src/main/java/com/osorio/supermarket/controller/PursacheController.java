package com.osorio.supermarket.controller;
import com.osorio.supermarket.entity.Pursache;
import com.osorio.supermarket.service.PursacheService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/pursaches")
@RestController
public class PursacheController {

    //Inyectando el servicio al controller
    @Autowired
    private PursacheService pursacheService;

    @GetMapping
    public ResponseEntity<List<Pursache>>getAllPursache(){
        return new ResponseEntity<>(pursacheService.getAllPursaches(), HttpStatus.OK);
    }

    @GetMapping("/{pursache-id}")
    public ResponseEntity<Optional<Pursache>>getPursacheById(@PathVariable ("pursache-id")int pursacheId){
        return new ResponseEntity<>(pursacheService.getPursacheById(pursacheId),HttpStatus.OK);
    }

    @PostMapping("/pursache")
    public ResponseEntity<Pursache>savePursache(@RequestBody Pursache pursache){
        return new ResponseEntity<>(pursacheService.savePursache(pursache), HttpStatus.CREATED);
    }

    @DeleteMapping("/{pursache-id}")
    public ResponseEntity<Void> deletePursacheById(@PathVariable("pursache-id") int pursacheId){
        System.out.println(pursacheId);
        pursacheService.deletePursacheById(pursacheId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{pursache-id}")
    public ResponseEntity<Pursache>updatePursacheById(@RequestBody @Valid Pursache pursache, @PathVariable("pursache-id")int pursacheId){
        return new ResponseEntity<>(pursacheService.updatePursacheById(pursache,pursacheId), HttpStatus.OK);
    }
}