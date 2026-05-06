package com.solutis.locadora.dto.filme;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FilmeResponse {

    private Long id;
    private String titulo;
    private String genero;
    private String diretor;

    public FilmeResponse() {
    }

    public FilmeResponse(Long id, String titulo, String genero, String diretor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
