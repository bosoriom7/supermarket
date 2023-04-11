package com.osorio.supermarket.mapper;

import com.osorio.supermarket.dto.request.PursacheRequest;
import com.osorio.supermarket.entity.Pursache;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PursacheMapper implements Function<PursacheRequest, Pursache> {

    @Override
    public Pursache apply(PursacheRequest pursacheRequest) {
        return new Pursache(pursacheRequest.getPursacheId(), pursacheRequest.getNamePursache(),pursacheRequest.getValor(),pursacheRequest.getColor());
    }
}
