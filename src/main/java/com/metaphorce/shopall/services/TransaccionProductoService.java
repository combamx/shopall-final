package com.metaphorce.shopall.services;

import com.metaphorce.shopall.repository.TransaccionProductoRepository;
import com.metaphorce.shopall.models.TransaccionProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionProductoService {

    @Autowired
    private TransaccionProductoRepository transaccionProductoRepository;

    public List<TransaccionProducto> findAll() {
        return transaccionProductoRepository.findAll();
    }

    public Optional<TransaccionProducto> findById(Long id) {
        return transaccionProductoRepository.findById(id);
    }

    public TransaccionProducto save(TransaccionProducto transaccionProducto) {
        return transaccionProductoRepository.save(transaccionProducto);
    }

    public void deleteById(Long id) {
        transaccionProductoRepository.deleteById(id);
    }
}
