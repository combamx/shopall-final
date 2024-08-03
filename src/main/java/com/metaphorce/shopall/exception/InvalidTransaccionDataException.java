package com.metaphorce.shopall.exception;

public class InvalidTransaccionDataException extends RuntimeException {
    public InvalidTransaccionDataException(String mensaje) {
        super(mensaje);
    }
}
