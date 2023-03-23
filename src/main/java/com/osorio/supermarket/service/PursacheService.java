package com.osorio.supermarket.service;

import com.osorio.supermarket.entity.Pursache;
import com.osorio.supermarket.repository.PursacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PursacheService {

    //Inyectando el repositorio en el servicio
    @Autowired
    private PursacheRepository pursacheRepository;

    public List<Pursache> getAllPursaches(){ return pursacheRepository.findAll();}

    public Pursache savePursache(Pursache pursache){return (Pursache) pursacheRepository.findAll();}
}
