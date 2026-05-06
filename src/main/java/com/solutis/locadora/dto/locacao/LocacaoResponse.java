package com.solutis.locadora.dto.locacao;

import java.time.LocalDate;

public class LocacaoResponse {

    private Long id;

    private ClienteResponse cliente;
    private FilmeResponse filme;

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Boolean devolvido;

    public static class ClienteResponse {
        private Long id;
        private String nome;
        private String email;
        public ClienteResponse() {}
        public ClienteResponse(Long id, String nome, String email) {
            this.id = id;
            this.nome = nome;
            this.email = email; }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }

    public static class FilmeResponse {
        private Long id;
        private String titulo;
        private String genero;
        private String diretor;
        public FilmeResponse() { }
        public FilmeResponse(Long id, String titulo, String genero, String diretor) {
            this.id = id;
            this.titulo = titulo;
            this.genero = genero;
            this.diretor = diretor; }
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
        public void setDiretor(String diretor) { this.diretor = diretor; }
    }

    public LocacaoResponse() {
    }

    public LocacaoResponse(Long id, ClienteResponse cliente, FilmeResponse filme, LocalDate dataLocacao, LocalDate dataDevolucao, Boolean devolvido) {
        this.id = id;
        this.cliente = cliente;
        this.filme = filme;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteResponse getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponse cliente) {
        this.cliente = cliente;
    }

    public FilmeResponse getFilme() {
        return filme;
    }

    public void setFilme(FilmeResponse filme) {
        this.filme = filme;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }
}
