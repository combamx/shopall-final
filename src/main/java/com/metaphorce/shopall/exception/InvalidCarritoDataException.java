package com.metaphorce.shopall.exception;

public class InvalidCarritoDataException extends RuntimeException {
    public InvalidCarritoDataException(String mensaje) {
        super(mensaje);
    }
}
