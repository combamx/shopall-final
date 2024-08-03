package com.metaphorce.shopall.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "comprador_id")
    private Usuario comprador;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<CarritoProducto> productos;

    // Getters y Setters

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", comprador=" + comprador +
                ", productos=" + productos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public List<CarritoProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CarritoProducto> productos) {
        this.productos = productos;
    }
}
