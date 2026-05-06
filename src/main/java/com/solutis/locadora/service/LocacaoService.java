package com.solutis.locadora.service;

import com.solutis.locadora.exception.EntidadeConflictException;
import com.solutis.locadora.exception.EntidadeNaoExisteException;
import com.solutis.locadora.model.Locacao;
import com.solutis.locadora.repository.ClienteRepository;
import com.solutis.locadora.repository.FilmeRepository;
import com.solutis.locadora.repository.LocacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final FilmeRepository filmeRepository;
    private final ClienteRepository clienteRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, FilmeRepository filmeRepository, ClienteRepository clienteRepository) {
        this.locacaoRepository = locacaoRepository;
        this.filmeRepository = filmeRepository;
        this.clienteRepository = clienteRepository;
    }

    public Locacao cadastrarLocacao(Locacao req) {
        if (locacaoRepository.existsByClienteIdAndFilmeIdAndDevolvidoFalse(
                req.getCliente().getId(), req.getFilme().getId())) { throw new EntidadeConflictException("Locação já existe!"); }

        if (!filmeRepository.existsById(req.getFilme().getId()) ||
            !clienteRepository.existsById(req.getCliente().getId())) {
            throw new EntidadeNaoExisteException("Entidade não existe!");
        }
        if (locacaoRepository.existsByFilmeIdAndDevolvidoFalse(req.getFilme().getId())) {
            throw new EntidadeConflictException("Filme já está alugado!");
        }

        Locacao locacao = new Locacao();
        locacao.setDataLocacao(LocalDate.now());
        locacao.setDevolvido(false);
        locacao.setCliente(clienteRepository.findById(req.getCliente().getId())
                .orElseThrow(() -> new EntidadeNaoExisteException("Cliente não encontrado!")));
        locacao.setFilme(filmeRepository.findById(req.getFilme().getId())
                .orElseThrow(() -> new EntidadeNaoExisteException("Filme não encontrado!")));

        return locacaoRepository.save(locacao);
    }

    public List<Locacao> listarTodos() {
        return locacaoRepository.findAll();
    }

    public Locacao devolverLocacao(Long id) {
        Locacao locacao = locacaoRepository.findById(id).orElseThrow(() -> new EntidadeNaoExisteException("Locação não encontrada!"));
        if (locacao.getDevolvido()) {
            throw new EntidadeConflictException("Locação já foi devolvida!");
        }
        locacao.setDevolvido(true);
        locacao.setDataDevolucao(LocalDate.now());
        return locacaoRepository.save(locacao);
    }
}
