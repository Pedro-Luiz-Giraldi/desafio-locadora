package com.solutis.locadora.controller;

import com.solutis.locadora.dto.locacao.LocacaoRequest;
import com.solutis.locadora.dto.locacao.LocacaoResponse;
import com.solutis.locadora.mapper.LocacaoMapper;
import com.solutis.locadora.model.Locacao;
import com.solutis.locadora.service.LocacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<LocacaoResponse> cadastrarLocacao(@RequestBody @Valid LocacaoRequest req) {
        Locacao locacao = locacaoService.cadastrarLocacao(LocacaoMapper.toEntity(req));
        return ResponseEntity.status(201).body(LocacaoMapper.toResponse(locacao));
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponse>> listarLocacoes() {
        List<Locacao> locacoes = locacaoService.listarTodos();
        if (locacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(LocacaoMapper.toResponse(locacoes));
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<LocacaoResponse> devolverLocacao(@PathVariable Long id) {
        Locacao locacao = locacaoService.devolverLocacao(id);
        return ResponseEntity.status(200).body(LocacaoMapper.toResponse(locacao));
    }
}
