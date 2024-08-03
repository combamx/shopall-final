package com.metaphorce.shopall.models.request;

public class CarritoRequest {

    private Long usuarioId;

    public CarritoRequest() {}

    public CarritoRequest(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
