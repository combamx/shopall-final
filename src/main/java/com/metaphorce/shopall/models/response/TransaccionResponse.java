package com.metaphorce.shopall.models.response;

import com.metaphorce.shopall.models.Usuario;

public class TransaccionResponse {

    public TransaccionResponse() {}

    public TransaccionResponse(Long comprador, double montoTotal, String direccionEnvio) {
        this.usuarioId = comprador;
        this.total = montoTotal;
        this.direccion = direccionEnvio;
    }

    private Long id;
    private Long usuarioId;
    private double total;
    private String fecha;
    private String direccion;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
