package com.metaphorce.shopall.exception;

public class InvalidProductoDataException extends RuntimeException {
    public InvalidProductoDataException(String mensaje) {
        super(mensaje);
    }
}
