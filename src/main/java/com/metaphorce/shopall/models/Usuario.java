package com.metaphorce.shopall.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {

    public Usuario(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo_usuario;

    public Usuario(String nombre, String email, String password, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipo_usuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo_usuario=" + tipo_usuario +
                '}';
    }

    public enum TipoUsuario {
        COMPRADOR,
        VENDEDOR
    }
    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipo_usuario;
    }

    public void setTipoUsuario(TipoUsuario tipo) {
        this.tipo_usuario = tipo;
    }
}