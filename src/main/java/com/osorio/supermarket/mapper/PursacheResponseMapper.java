package com.osorio.supermarket.mapper;

import com.osorio.supermarket.dto.response.PursacheResponse;
import com.osorio.supermarket.entity.Pursache;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PursacheResponseMapper implements Function<Pursache, PursacheResponse> {
    @Override
    public PursacheResponse apply(Pursache pursache) {
        return new PursacheResponse(pursache.getPursacheId(), pursache.getNamePursache(), pursache.getValor());
    }
}
