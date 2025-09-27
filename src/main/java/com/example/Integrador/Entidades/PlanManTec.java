
package com.example.Integrador.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad que representa la relación entre una maquinaria, un mantenimiento y un técnico.
 * Permite asociar qué técnico realiza qué mantenimiento a qué maquinaria.
 */
@Entity
public class PlanManTec {
    
	/**
	 * Identificador único de la relación (clave primaria).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	/**
	 * Identificador de la maquinaria asociada.
	 */
	private int idMaquinaria;
	/**
	 * Identificador del mantenimiento asociado.
	 */
	private int idMantenimiento;
	/**
	 * Identificador del técnico asociado.
	 */
	private int idTecnico;
    
	/**
	 * Obtiene el identificador de la relación.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el identificador de la relación.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene el identificador de la maquinaria.
	 */
	public int getIdMaquinaria() {
		return idMaquinaria;
	}
	/**
	 * Establece el identificador de la maquinaria.
	 */
	public void setIdMaquinaria(int idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}
	/**
	 * Obtiene el identificador del mantenimiento.
	 */
	public int getIdMantenimiento() {
		return idMantenimiento;
	}
	/**
	 * Establece el identificador del mantenimiento.
	 */
	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	/**
	 * Obtiene el identificador del técnico.
	 */
	public int getIdTecnico() {
		return idTecnico;
	}
	/**
	 * Establece el identificador del técnico.
	 */
	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
    
}
