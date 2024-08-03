package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.models.TransaccionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionProductoRepository extends JpaRepository<TransaccionProducto, Long> {
}
