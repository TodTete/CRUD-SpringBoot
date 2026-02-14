package com.example.demo.repository;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para la entidad Producto.
 * Proporciona operaciones CRUD automáticas sin necesidad de implementación.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
