package com.metaphorce.shopall.models.request;

public class CarritoProductoRequest {

    private Long carritoId;
    private Long productoId;
    private int cantidad;

    public CarritoProductoRequest() {}

    public CarritoProductoRequest(Long carritoId, Long productoId, int cantidad) {
        this.carritoId = carritoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Long getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
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
}
