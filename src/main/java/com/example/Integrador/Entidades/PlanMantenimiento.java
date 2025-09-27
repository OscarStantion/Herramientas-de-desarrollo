
package com.example.Integrador.Entidades;

import jakarta.persistence.*;

/**
 * Entidad que representa un plan de mantenimiento en el sistema.
 * Cada plan tiene un nombre, una descripción y un precio asociado.
 */
@Entity
@Table(name = "plan_mantenimiento")
public class PlanMantenimiento {

    /**
     * Identificador único del plan de mantenimiento (clave primaria).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre del plan de mantenimiento.
     */
    private String nombre;

    /**
     * Descripción detallada del plan de mantenimiento.
     */
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    /**
     * Precio del plan de mantenimiento.
     */
    private double precio;

    // Getters y Setters

    /**
     * Obtiene el identificador del plan.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del plan.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del plan de mantenimiento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del plan de mantenimiento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del plan de mantenimiento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del plan de mantenimiento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del plan de mantenimiento.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del plan de mantenimiento.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
