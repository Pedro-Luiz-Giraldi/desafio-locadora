package com.solutis.locadora.mapper;

import com.solutis.locadora.dto.locacao.LocacaoRequest;
import com.solutis.locadora.dto.locacao.LocacaoResponse;
import com.solutis.locadora.model.Cliente;
import com.solutis.locadora.model.Filme;
import com.solutis.locadora.model.Locacao;

import java.util.ArrayList;
import java.util.List;

public class LocacaoMapper {

    public static LocacaoResponse toResponse(Locacao locacao) {
        if (locacao == null) {
            return null;
        }

        LocacaoResponse response = new LocacaoResponse();
        response.setId(locacao.getId());

        //response.setCliente(ClienteMapper.toLocacaoResponse(locacao.getCliente()));
        //response.setFilme(FilmeMapper.toLocacaoResponse(locacao.getFilme()));
        response.setCliente(new LocacaoResponse.ClienteResponse());
        response.getCliente().setId(locacao.getCliente().getId());
        response.getCliente().setEmail(locacao.getCliente().getEmail());
        response.getCliente().setNome(locacao.getCliente().getNome());

        response.setFilme(new LocacaoResponse.FilmeResponse());
        response.getFilme().setId(locacao.getFilme().getId());
        response.getFilme().setDiretor(locacao.getFilme().getDiretor());
        response.getFilme().setGenero(locacao.getFilme().getGenero());
        response.getFilme().setTitulo(locacao.getFilme().getTitulo());

        response.setDataLocacao(locacao.getDataLocacao());
        response.setDataDevolucao(locacao.getDataDevolucao());
        response.setDevolvido(locacao.getDevolvido());

        return response;
    }


    public static List<LocacaoResponse> toResponse(List<Locacao> locacoes) {
        List<LocacaoResponse> responses = new ArrayList<>();
        for (Locacao locacao : locacoes) {
            responses.add(toResponse(locacao));
        }
        return responses;
    }

    public static Locacao toEntity(LocacaoRequest req) {
        if (req == null) {
            return null;
        }

        Locacao locacao = new Locacao();
        locacao.setFilme(new Filme());
        locacao.getFilme().setId(req.getFilmeId());
        locacao.setCliente(new Cliente());
        locacao.getCliente().setId(req.getClienteId());

        return locacao;
    }
}