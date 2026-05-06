package com.solutis.locadora.repository;

import com.solutis.locadora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Boolean existsByNomeAndEmail(String nome, String email);
}