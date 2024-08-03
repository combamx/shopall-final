package com.metaphorce.shopall.services.test;

import com.metaphorce.shopall.exception.InvalidProductoDataException;
import com.metaphorce.shopall.exception.NotFoundException;
import com.metaphorce.shopall.models.Producto;
import com.metaphorce.shopall.repository.ProductoRepository;
import com.metaphorce.shopall.services.ProductoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    ProductoServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProductos() {
        when(productoRepository.findAll()).thenReturn(List.of(new Producto()));
        assertFalse(productoService.getAllProductos().isEmpty());
    }

    @Test
    void getProductoById() {
        Producto producto = new Producto();
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        assertEquals(producto, productoService.getProductoById(1L));
    }

    @Test
    void getProductoByIdNotFound() {
        when(productoRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(InvalidProductoDataException.class, () -> productoService.getProductoById(1L));
    }

    // Add more tests for createProducto, updateProducto, and deleteProducto
}
