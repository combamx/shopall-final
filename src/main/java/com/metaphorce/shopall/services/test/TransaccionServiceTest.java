package com.metaphorce.shopall.services.test;

import com.metaphorce.shopall.exception.NotFoundException;
import com.metaphorce.shopall.models.Transaccion;
import com.metaphorce.shopall.repository.TransaccionRepository;
import com.metaphorce.shopall.services.TransaccionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransaccionServiceTest {

    @Mock
    private TransaccionRepository transaccionRepository;

    @InjectMocks
    private TransaccionService transaccionService;

    TransaccionServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTransacciones() {
        when(transaccionRepository.findAll()).thenReturn(List.of(new Transaccion()));
        assertFalse(transaccionService.findAll().isEmpty());
    }

    @Test
    void getTransaccionById() {
        Transaccion transaccion = new Transaccion();
        when(transaccionRepository.findById(1L)).thenReturn(Optional.of(transaccion));
        assertEquals(transaccion, transaccionService.findById(1L));
    }

    @Test
    void getTransaccionByIdNotFound() {
        when(transaccionRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> transaccionService.findById(1L));
    }

    // Add more tests for createTransaccion, updateTransaccion, and deleteTransaccion
}