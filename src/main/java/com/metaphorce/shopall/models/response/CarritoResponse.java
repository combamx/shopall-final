package com.metaphorce.shopall.models.response;

public class CarritoResponse {

    public CarritoResponse() {}

    public CarritoResponse(Long id, Long usuarioIdl) {
        this.id = id;
        this.usuarioId = usuarioId;
    }

    private Long id;
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
