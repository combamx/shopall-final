package com.metaphorce.shopall.models.response;

import java.math.BigDecimal;

public class TransaccionProductoResponse {

    public TransaccionProductoResponse() {}

    public TransaccionProductoResponse(Long id, Long transaccionId, Long productoId, int cantidad, BigDecimal precio) {
        this.id = id;
        this.transaccionId = transaccionId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    private Long id;
    private Long transaccionId;
    private Long productoId;
    private int cantidad;
    private BigDecimal precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Long transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
