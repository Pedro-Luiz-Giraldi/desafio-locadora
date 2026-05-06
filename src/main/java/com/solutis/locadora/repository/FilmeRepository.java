package com.solutis.locadora.repository;

import com.solutis.locadora.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Boolean existsByDiretorAndTitulo(String diretor, String titulo);
}