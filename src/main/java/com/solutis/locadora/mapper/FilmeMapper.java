package com.solutis.locadora.mapper;

import com.solutis.locadora.dto.filme.FilmeRequest;
import com.solutis.locadora.dto.filme.FilmeResponse;
import com.solutis.locadora.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static Filme toEntity(FilmeRequest req) {
        return new Filme(req.getTitulo(), req.getGenero(), req.getDiretor());
    }

    public static FilmeResponse toResponse(Filme filme) {
        return new FilmeResponse(filme.getId(), filme.getTitulo(), filme.getGenero(), filme.getDiretor());
    }

    /*
    public static LocacaoResponse.FilmeResponse toLocacaoResponse(Filme filme) {
        return new LocacaoResponse.FilmeResponse(filme.getId(), filme.getTitulo(), filme.getGenero(), filme.getDiretor());
    }
     */

    public static List<FilmeResponse> toResponse(List<Filme> filmes) {
        List<FilmeResponse> responses = new ArrayList<>();
        for (Filme f : filmes) {
            responses.add(new FilmeResponse(f.getId(), f.getTitulo(), f.getGenero(), f.getDiretor()));
        }
        return responses;
    }
}
