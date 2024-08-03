package com.metaphorce.shopall.services;

import com.metaphorce.shopall.repository.CarritoProductoRepository;
import com.metaphorce.shopall.models.CarritoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoProductoService {

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    public List<CarritoProducto> findAll() {
        return carritoProductoRepository.findAll();
    }

    public Optional<CarritoProducto> findById(Long id) {
        return carritoProductoRepository.findById(id);
    }

    public CarritoProducto save(CarritoProducto carritoProducto) {
        return carritoProductoRepository.save(carritoProducto);
    }

    public void deleteById(Long id) {
        carritoProductoRepository.deleteById(id);
    }
}
