package com.example.Integrador.Entidades;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MantenimientoSeleccionado {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	    private LocalDate fechaSalida;
	    private String tipos;
		public MantenimientoSeleccionado(int id, LocalDate fechaSalida, String tipos) {
			super();
			this.id = id;
			this.fechaSalida = fechaSalida;
			this.tipos = tipos;
		}
		public MantenimientoSeleccionado() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public LocalDate getFechaSalida() {
			return fechaSalida;
		}
		public void setFechaSalida(LocalDate fechaSalida) {
			this.fechaSalida = fechaSalida;
		}
		public String getTipos() {
			return tipos;
		}
		public void setTipos(String tipos) {
			this.tipos = tipos;
		}
		
}
