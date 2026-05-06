package com.solutis.locadora.mapper;

import com.solutis.locadora.dto.cliente.ClienteRequest;
import com.solutis.locadora.dto.cliente.ClienteResponse;
import com.solutis.locadora.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public static Cliente toEntity(ClienteRequest req) {
        return new Cliente(req.getNome(), req.getEmail());
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    /*
    public static LocacaoResponse.ClienteResponse toLocacaoResponse(Cliente cliente) {
        return new LocacaoResponse.ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
     */

    public static List<ClienteResponse> toResponse(List<Cliente> clientes) {
        List<ClienteResponse> responses = new ArrayList<>();
        for (Cliente cliente : clientes) {
            responses.add(toResponse(cliente));
        }
        return responses;
    }
}
