package com.metaphorce.shopall.models.request;

import java.math.BigDecimal;

public class TransaccionProductoRequest {

    private Long transaccionId;
    private Long productoId;
    private int cantidad;
    private BigDecimal precio;

    public TransaccionProductoRequest() {}

    public TransaccionProductoRequest(Long transaccionId, Long productoId, int cantidad, BigDecimal precio) {
        this.transaccionId = transaccionId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
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
