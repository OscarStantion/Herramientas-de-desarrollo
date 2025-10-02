package com.example.Integrador.Entidades;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad que representa los mantenimientos seleccionados para una maquinaria.
 * Almacena la fecha de salida y los tipos de mantenimiento programados.
 */
@Entity
public class MantenimientoSeleccionado {

	/**
	 * Identificador único del mantenimiento seleccionado (clave primaria).
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Fecha programada para la salida del mantenimiento.
	 */
	private LocalDate fechaSalida;
	
	/**
	 * Tipos de mantenimiento seleccionados.
	 */
	private String tipos;
		
	/**
	 * Constructor con todos los parámetros.
	 * @param id Identificador del mantenimiento
	 * @param fechaSalida Fecha programada para el mantenimiento
	 * @param tipos Tipos de mantenimiento seleccionados
	 */
	public MantenimientoSeleccionado(int id, LocalDate fechaSalida, String tipos) {
		super();
		this.id = id;
		this.fechaSalida = fechaSalida;
		this.tipos = tipos;
	}
	
	/**
	 * Constructor vacío.
	 */
	public MantenimientoSeleccionado() {
		super();
	}
	/**
	 * Obtiene el identificador del mantenimiento seleccionado.
	 * @return El identificador único
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Establece el identificador del mantenimiento seleccionado.
	 * @param id El identificador único
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene la fecha programada para el mantenimiento.
	 * @return La fecha de salida
	 */
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	
	/**
	 * Establece la fecha programada para el mantenimiento.
	 * @param fechaSalida La fecha de salida
	 */
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	/**
	 * Obtiene los tipos de mantenimiento seleccionados.
	 * @return Los tipos de mantenimiento
	 */
	public String getTipos() {
		return tipos;
	}
	
	/**
	 * Establece los tipos de mantenimiento seleccionados.
	 * @param tipos Los tipos de mantenimiento
	 */
	public void setTipos(String tipos) {
		this.tipos = tipos;
	}
		
}
