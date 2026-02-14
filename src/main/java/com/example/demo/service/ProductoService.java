package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Capa de servicio que contiene la lógica de negocio.
 * Interactúa entre el Controller y el Repository.
 */
@Service
public class ProductoService {

    // Inyección del repositorio
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    /**
     * Retorna todos los productos.
     */
    public List<Producto> listar() {
        return repository.findAll();
    }

    /**
     * Busca un producto por ID.
     */
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Guarda un nuevo producto o actualiza si ya existe.
     */
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    /**
     * Actualiza un producto existente.
     * Se asigna el ID recibido al objeto antes de guardar.
     */
    public Producto actualizar(Long id, Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    /**
     * Elimina un producto por ID.
     */
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
