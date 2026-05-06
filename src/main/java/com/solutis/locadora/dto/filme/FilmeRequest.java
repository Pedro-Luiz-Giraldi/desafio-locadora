package com.solutis.locadora.dto.filme;

import jakarta.validation.constraints.NotBlank;

public class FilmeRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String genero;

    @NotBlank
    private String diretor;

    public FilmeRequest() {
    }

    public FilmeRequest(String diretor, String genero, String titulo) {
        this.diretor = diretor;
        this.genero = genero;
        this.titulo = titulo;
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
