package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.PursacheRequest;
import com.osorio.supermarket.dto.response.PursacheResponse;
import com.osorio.supermarket.entity.Pursache;
import com.osorio.supermarket.mapper.PursacheMapper;
import com.osorio.supermarket.mapper.PursacheResponseMapper;
import com.osorio.supermarket.repository.PursacheRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PursacheServiceImpl implements PurchaseService{


    private String ERROR_PURSACHE = "Id de pursache no encontrado";
    //Inyectando el repositorio en el servicio
    //Se declara final cuando no nos interesa crear clases derivadas de dicha clase
    private final PursacheRepository pursacheRepository;

    private final PursacheMapper pursacheMapper;

    private final PursacheResponseMapper pursacheResponseMapper;

    //Constructor
    public PursacheServiceImpl(PursacheRepository pursacheRepository, PursacheMapper pursacheMapper, PursacheResponseMapper pursacheResponseMapper) {
        this.pursacheRepository = pursacheRepository;
        this.pursacheMapper = pursacheMapper;
        this.pursacheResponseMapper = pursacheResponseMapper;
    }

    //Sobrescribiendo los métodos
    @Override
    public List<PursacheResponse> getAllPursaches(){
        return pursacheRepository.findAll().stream().map(pursacheResponseMapper).toList();}

    @Override
    public void deletePursacheById(int pursacheId){
        Optional<Pursache> pursache = pursacheRepository.findById(pursacheId);
        if (pursache.isPresent()) {
            pursacheRepository.deleteById(pursacheId);
        }
    }

    @Override
    public Optional<String>getColorById(int pursacheId){
        return pursacheRepository.findById(pursacheId)
                .map(pursache->pursache.getColor())
                .or(()->{throw new IllegalArgumentException(ERROR_PURSACHE);});
    }

    @Override
    public PursacheResponse updatePursacheById(PursacheRequest pursacheRequest){
        Pursache pursache = pursacheMapper.apply(pursacheRequest);
        return pursacheRepository.findById(pursache.getPursacheId())
                .map(existingPursache ->pursacheRepository.save(pursache))
                .map(pursacheResponseMapper)
                .orElseThrow(()-> new IllegalArgumentException(ERROR_PURSACHE));
    }

/*    @Override
    public Optional <PursacheResponse> getPursacheById(int pursacheId){
        return pursacheRepository.findById(pursacheId)
                .map(pursacheResponseMapper)
                .or(()->{throw new IllegalArgumentException(ERROR_PURSACHE);});
    }*/


    @Override
    public PursacheResponse savePursache(PursacheRequest pursacheRequest) {
        Pursache pursache = pursacheMapper.apply(pursacheRequest);
        Pursache savePursache = pursacheRepository.save(pursache);
        return pursacheResponseMapper.apply(savePursache);
     }

}
