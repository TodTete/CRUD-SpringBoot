package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa la tabla "productos" en la base de datos.
 */
@Entity
@Table(name = "productos")
@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    /**
     * Clave primaria autogenerada.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private Double precio;

    /**
     * Cantidad disponible en inventario.
     */
    private Integer stock;

    /**
     * Categoría del producto.
     */
    private String categoria;
}
