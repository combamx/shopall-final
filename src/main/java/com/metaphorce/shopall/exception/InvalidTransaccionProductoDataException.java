package com.metaphorce.shopall.exception;

public class InvalidTransaccionProductoDataException extends RuntimeException {
    public InvalidTransaccionProductoDataException(String mensaje) {
        super(mensaje);
    }
}
