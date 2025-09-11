package com.example.Integrador.DTOs;
import java.time.LocalDate;
import java.util.List;

public class SeleccionMantenimientoDTO {
	private List<Long> tiposSeleccionados;
	private LocalDate fechaSalida;
    private Integer idMaquinaria;

    public Integer getIdMaquinaria() {
		return idMaquinaria;
	}

	public void setIdMaquinaria(Integer idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}


    public List<Long> getTiposSeleccionados() {
		return tiposSeleccionados;
	}

	public void setTiposSeleccionados(List<Long> tiposSeleccionados) {
		this.tiposSeleccionados = tiposSeleccionados;
	}

	public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
