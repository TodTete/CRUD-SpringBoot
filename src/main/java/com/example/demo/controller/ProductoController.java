package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints del CRUD de Productos.
 * Maneja las peticiones HTTP y delega la lógica al servicio.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Inyección de dependencias del servicio
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    /**
     * Obtiene la lista completa de productos.
     * GET /api/productos
     */
    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    /**
     * Obtiene un producto por su ID.
     * GET /api/productos/{id}
     */
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return service.obtenerPorId(id).orElse(null);
    }

    /**
     * Crea un nuevo producto.
     * POST /api/productos
     */
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    /**
     * Actualiza un producto existente.
     * PUT /api/productos/{id}
     */
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return service.actualizar(id, producto);
    }

    /**
     * Elimina un producto por ID.
     * DELETE /api/productos/{id}
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
