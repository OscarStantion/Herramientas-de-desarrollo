package com.example.Integrador.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maquinaria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	 private String apellido;	    
	    private String numeroCelular;
	    private String gmail;
	    private String marca;
	    private String modelo;
	    private String numeroSerie;
	    private String tipoMaquinaria;
	    private int anioFabricacion;
	    private String numeroMotor;
	    private double horasOperacion;
	    private double kilometraje;
	    
		public Maquinaria(String nombre, String apellido, String numeroCelular, String gmail, String marca,
				String modelo, String numeroSerie, String tipoMaquinaria, int anioFabricacion, String numeroMotor,
				double horasOperacion, double kilometraje) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.numeroCelular = numeroCelular;
			this.gmail = gmail;
			this.marca = marca;
			this.modelo = modelo;
			this.numeroSerie = numeroSerie;
			this.tipoMaquinaria = tipoMaquinaria;
			this.anioFabricacion = anioFabricacion;
			this.numeroMotor = numeroMotor;
			this.horasOperacion = horasOperacion;
			this.kilometraje = kilometraje;
		}
		public Maquinaria(int id, String nombre, String apellido, String numeroCelular, String gmail, String marca,
				String modelo, String numeroSerie, String tipoMaquinaria, int anioFabricacion, String numeroMotor,
				double horasOperacion, double kilometraje) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.numeroCelular = numeroCelular;
			this.gmail = gmail;
			this.marca = marca;
			this.modelo = modelo;
			this.numeroSerie = numeroSerie;
			this.tipoMaquinaria = tipoMaquinaria;
			this.anioFabricacion = anioFabricacion;
			this.numeroMotor = numeroMotor;
			this.horasOperacion = horasOperacion;
			this.kilometraje = kilometraje;
		}
		public Maquinaria() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getNumeroCelular() {
			return numeroCelular;
		}
		public void setNumeroCelular(String numeroCelular) {
			this.numeroCelular = numeroCelular;
		}
		public String getGmail() {
			return gmail;
		}
		public void setGmail(String gmail) {
			this.gmail = gmail;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getNumeroSerie() {
			return numeroSerie;
		}
		public void setNumeroSerie(String numeroSerie) {
			this.numeroSerie = numeroSerie;
		}
		public String getTipoMaquinaria() {
			return tipoMaquinaria;
		}
		public void setTipoMaquinaria(String tipoMaquinaria) {
			this.tipoMaquinaria = tipoMaquinaria;
		}
		public int getAnioFabricacion() {
			return anioFabricacion;
		}
		public void setAnioFabricacion(int anioFabricacion) {
			this.anioFabricacion = anioFabricacion;
		}
		public String getNumeroMotor() {
			return numeroMotor;
		}
		public void setNumeroMotor(String numeroMotor) {
			this.numeroMotor = numeroMotor;
		}
		public double getHorasOperacion() {
			return horasOperacion;
		}
		public void setHorasOperacion(double horasOperacion) {
			this.horasOperacion = horasOperacion;
		}
		public double getKilometraje() {
			return kilometraje;
		}
		public void setKilometraje(double kilometraje) {
			this.kilometraje = kilometraje;
		}

	    
}
