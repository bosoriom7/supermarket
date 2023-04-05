package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.PursacheRequest;
import com.osorio.supermarket.dto.response.PursacheResponse;
import com.osorio.supermarket.entity.Pursache;
import com.osorio.supermarket.repository.PursacheRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PursacheServiceImpl implements PurchaseService{

    //Inyectando el repositorio en el servicio
    //Se declara final cuando no nos interesa crear clases derivadas de dicha clase
    private final PursacheRepository pursacheRepository;

    //Constructor
    public PursacheServiceImpl(PursacheRepository pursacheRepository) {this.pursacheRepository = pursacheRepository;}

    //Sobrescribiendo los métodos
    @Override
    public List<Pursache> getAllPursaches(){ return pursacheRepository.findAll();}

 /*   @Override
    public Pursache savePursache(PursacheRequest pursacheRequest){return (Pursache) pursacheRepository.save(pursache);}
*/
    @Override
    public void deletePursacheById(int pursacheId){
        Optional<Pursache> pursache = pursacheRepository.findById(pursacheId);
        if (pursache.isPresent()) {
            pursacheRepository.deleteById(pursacheId);
        }
    }

    @Override
    public Pursache updatePursacheById(Pursache pursache, int pursacheId){
        Optional<Pursache> pursacheToUpdate = pursacheRepository.findById(pursacheId);
        if (pursacheToUpdate.isPresent()){
            pursache.setPursacheId(pursacheId);
            pursache = pursacheRepository.save(pursache);
        }return pursache;
    }

    @Override
    public Optional <Pursache> getPursacheById(int pursacheId){
        return pursacheRepository.findById(pursacheId);
    }

    @Override
    public PursacheResponse savePursache(PursacheRequest pursacheRequest) {
        Pursache pursache = new Pursache(0, pursacheRequest.getNamePursache(),pursacheRequest.getValor(),pursacheRequest.getColor());
        Pursache purchaseSave = pursacheRepository.save(pursache);
        return new PursacheResponse(purchaseSave.getNamePursache(),purchaseSave.getValor());
    }

}
