package com.example.Integrador.DTOs;

import java.time.LocalDate;

import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Entidades.RelacionMantenimiento;

public class HistorialPagoDTO {
	/*private Maquinaria maquinaria;
    private RelacionMantenimiento mantenimiento;
    private PlanMantenimiento plan;  */
	
	 private Integer id;              // ID de la maquinaria
	    private String nombre;          // Nombre del cliente o maquinaria
	    private String modelo;          // Modelo de la maquinaria
	    private LocalDate fechaSalida;  // Fecha del mantenimiento
	    private String tipo;            // Nombre del plan de mantenimiento
	    private double subtotal;        // Precio base
	    private double total;           // Precio con IGV
		
	    
	    public HistorialPagoDTO() {
			super();
		}
		public HistorialPagoDTO(Integer id, String nombre, String modelo, LocalDate fechaSalida, String tipo,
				double subtotal, double total) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.modelo = modelo;
			this.fechaSalida = fechaSalida;
			this.tipo = tipo;
			this.subtotal = subtotal;
			this.total = total;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public LocalDate getFechaSalida() {
			return fechaSalida;
		}
		public void setFechaSalida(LocalDate fechaSalida) {
			this.fechaSalida = fechaSalida;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public double getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(double subtotal) {
			this.subtotal = subtotal;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
    
    

    
    
}

