package com.example.Integrador.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RelacionMantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idMaquinaria;
    private Integer idTecnico;
    private Integer idPlan;
    private LocalDate fechaSalida;
    private String estado; // PENDIENTE, COMPLETADO
    
    // Constructor
    public RelacionMantenimiento() {
        this.estado = "PENDIENTE";
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdMaquinaria() {
		return idMaquinaria;
	}
	public void setIdMaquinaria(Integer idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}
	public Integer getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}
	public Integer getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

    // Getters y Setters
    
    
}
