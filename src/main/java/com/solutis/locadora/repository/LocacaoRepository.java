package com.solutis.locadora.repository;

import com.solutis.locadora.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    Boolean existsByClienteIdAndFilmeIdAndDevolvidoFalse(Long clienteId, Long filmeId);

    Boolean existsByFilmeIdAndDevolvidoFalse(Long filmeId);
}