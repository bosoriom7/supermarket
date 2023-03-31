package com.osorio.supermarket.service;

import com.osorio.supermarket.controller.entity.Pursache;
import com.osorio.supermarket.repository.PursacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PursacheService {

    //Inyectando el repositorio en el servicio
    @Autowired
    private PursacheRepository pursacheRepository;

    public List<Pursache> getAllPursaches(){ return pursacheRepository.findAll();}

    public Pursache savePursache(Pursache pursache){return (Pursache) pursacheRepository.save(pursache);}

    public void deletePursacheById(int pursacheId){
        Optional<Pursache> pursache = pursacheRepository.findById(pursacheId);
        if (pursache.isPresent()) {
            pursacheRepository.deleteById(pursacheId);
        }
    }

    public Pursache updatePursacheById(Pursache pursache, int pursacheId){
        Optional<Pursache> pursacheToUpdate = pursacheRepository.findById(pursacheId);
        if (pursacheToUpdate.isPresent()){
            pursache.setPursacheId(pursacheId);
            pursache = pursacheRepository.save(pursache);
        }return pursache;
    }

    public Optional <Pursache> getPursacheById(int pursacheId){
        return pursacheRepository.findById(pursacheId);
    }
}
