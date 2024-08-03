package com.metaphorce.shopall.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    public Transaccion(){}

    public Transaccion(Usuario comprador, @NotNull double montoTotal, String direccionEnvio, String informacionPago) {
        this.comprador = comprador;
        this.montoTotal = montoTotal;
        this.direccionEnvio = direccionEnvio;
        this.informacionPago = informacionPago;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Usuario comprador;

    @NotNull
    private double montoTotal;

    @NotBlank
    private String direccionEnvio;

    @NotBlank
    private String informacionPago;

    private LocalDateTime fecha;

    @OneToMany(mappedBy = "transaccion", cascade = CascadeType.ALL)
    private List<TransaccionProducto> productos;

    // Getters y Setters

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", comprador=" + comprador +
                ", montoTotal=" + montoTotal +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                ", informacionPago='" + informacionPago + '\'' +
                ", fecha=" + fecha +
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

    public @NotNull double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(@NotNull double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public @NotBlank String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(@NotBlank String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public @NotBlank String getInformacionPago() {
        return informacionPago;
    }

    public void setInformacionPago(@NotBlank String informacionPago) {
        this.informacionPago = informacionPago;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<TransaccionProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<TransaccionProducto> productos) {
        this.productos = productos;
    }
}