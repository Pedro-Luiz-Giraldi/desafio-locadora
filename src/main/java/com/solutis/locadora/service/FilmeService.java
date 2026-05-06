package com.solutis.locadora.service;

import com.solutis.locadora.dto.filme.FilmeRequest;
import com.solutis.locadora.exception.EntidadeConflictException;
import com.solutis.locadora.mapper.FilmeMapper;
import com.solutis.locadora.model.Filme;
import com.solutis.locadora.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme cadastrarFilme(Filme req) {
        if (filmeRepository.existsByDiretorAndTitulo(
                req.getDiretor(), req.getTitulo())) { throw new EntidadeConflictException("Filme já existe!"); }
        return filmeRepository.save(req);
    }

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }
}
