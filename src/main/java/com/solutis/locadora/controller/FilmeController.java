package com.solutis.locadora.controller;

import com.solutis.locadora.dto.filme.FilmeRequest;
import com.solutis.locadora.dto.filme.FilmeResponse;
import com.solutis.locadora.mapper.FilmeMapper;
import com.solutis.locadora.model.Filme;
import com.solutis.locadora.repository.FilmeRepository;
import com.solutis.locadora.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping
    public ResponseEntity<FilmeResponse> cadastrarFilme(@RequestBody @Valid FilmeRequest req) {
        Filme filme = filmeService.cadastrarFilme(FilmeMapper.toEntity(req));
        return ResponseEntity.status(201).body(FilmeMapper.toResponse(filme));
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponse>> listarFilmes() {
        List<Filme> filmes = filmeService.listarTodos();
        if (filmes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(FilmeMapper.toResponse(filmes));
    }
}
