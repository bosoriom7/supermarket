package com.osorio.supermarket.controller;
import com.osorio.supermarket.entity.Pursache;
import com.osorio.supermarket.service.PursacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PursacheController {

    //Inyectando el servicio al controller
    @Autowired
    private PursacheService pursacheService;

    @GetMapping("/pursache")
    public ResponseEntity<List<Pursache>>getAllPursache(){
        return new ResponseEntity<>(pursacheService.getAllPursaches(), HttpStatus.OK);
    }

    @PostMapping("/pursache")
    public ResponseEntity<Pursache>savePursache(@RequestBody Pursache pursache){
        return new ResponseEntity<>(pursacheService.savePursache(pursache), HttpStatus.OK);
    }
}