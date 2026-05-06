package com.solutis.locadora.dto.locacao;

import jakarta.validation.constraints.NotNull;

public class LocacaoRequest {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long filmeId;

    public LocacaoRequest(Long clienteId, Long filmeId) {
        this.clienteId = clienteId;
        this.filmeId = filmeId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }
}