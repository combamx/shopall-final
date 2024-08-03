package com.metaphorce.shopall.models.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TransaccionRequest {

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    @Min(value = 0, message = "El total debe ser mayor o igual a 0")
    private double total;

    @NotBlank(message = "La fecha es obligatoria")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe estar en el formato YYYY-MM-DD")
    private String fecha;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    public String getInformacionPago() {
        return informacionPago;
    }

    public void setInformacionPago(String informacionPago) {
        this.informacionPago = informacionPago;
    }

    private String informacionPago;

    public TransaccionRequest() {}

    public TransaccionRequest(Long usuarioId, double total, String fecha, String direccion, String informacionPago) {
        this.usuarioId = usuarioId;
        this.total = total;
        this.fecha = fecha;
        this.direccion = direccion;
        this.informacionPago = informacionPago;
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
