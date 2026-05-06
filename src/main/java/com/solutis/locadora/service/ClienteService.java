package com.solutis.locadora.service;

import com.solutis.locadora.dto.cliente.ClienteRequest;
import com.solutis.locadora.exception.EntidadeConflictException;
import com.solutis.locadora.mapper.ClienteMapper;
import com.solutis.locadora.model.Cliente;
import com.solutis.locadora.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente req) {
        if (clienteRepository.existsByNomeAndEmail(
                req.getNome(), req.getEmail())) { throw new EntidadeConflictException("Cliente já existe!"); }
        return clienteRepository.save(req);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
}
