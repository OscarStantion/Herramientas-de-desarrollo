package com.example.Integrador.DTOs;
import java.time.LocalDate;
import java.util.List;

public class SeleccionMantenimientoDTO {
	// Tipos elegidos
	private List<Long> tiposSeleccionados;
	// Fecha salida
	private LocalDate fechaSalida;
	// Id maquinaria
	private Integer idMaquinaria;

	// Obtener id maquinaria
	public Integer getIdMaquinaria() {
		return idMaquinaria;
	}

	// Establecer id maquinaria
	public void setIdMaquinaria(Integer idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}


	// Obtener tipos seleccionados
	public List<Long> getTiposSeleccionados() {
		return tiposSeleccionados;
	}

	// Establecer tipos seleccionados
	public void setTiposSeleccionados(List<Long> tiposSeleccionados) {
		this.tiposSeleccionados = tiposSeleccionados;
	}

	// Obtener fecha salida
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	// Establecer fecha salida
	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
}
