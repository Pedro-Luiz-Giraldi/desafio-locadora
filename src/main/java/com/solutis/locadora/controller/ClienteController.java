package com.solutis.locadora.controller;

import com.solutis.locadora.dto.cliente.ClienteRequest;
import com.solutis.locadora.dto.cliente.ClienteResponse;
import com.solutis.locadora.mapper.ClienteMapper;
import com.solutis.locadora.model.Cliente;
import com.solutis.locadora.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody @Valid ClienteRequest req) {
        Cliente cliente = clienteService.cadastrarCliente(ClienteMapper.toEntity(req));
        return ResponseEntity.status(201).body(ClienteMapper.toResponse(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodos();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ClienteMapper.toResponse(clientes));
    }
}
