
package com.example.Integrador.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maquinaria {
	/**
	 * Identificador único de la maquinaria (clave primaria).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** Nombre de la maquinaria. */
	private String nombre;
	/** Apellido del responsable o referencia. */
	private String apellido;
	/** Número de celular de contacto. */
	private String numeroCelular;
	/** Correo electrónico de contacto. */
	private String gmail;
	/** Marca de la maquinaria. */
	private String marca;
	/** Modelo de la maquinaria. */
	private String modelo;
	/** Número de serie de la maquinaria. */
	private String numeroSerie;
	/** Tipo de maquinaria. */
	private String tipoMaquinaria;
	/** Año de fabricación. */
	private int anioFabricacion;
	/** Número de motor. */
	private String numeroMotor;
	/** Horas de operación acumuladas. */
	private double horasOperacion;
	/** Kilometraje acumulado. */
	private double kilometraje;

	/**
	 * Constructor con todos los campos excepto el id.
	 */
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

	/**
	 * Constructor con todos los campos incluyendo el id.
	 */
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

	/**
	 * Constructor vacío.
	 */
	public Maquinaria() {
		super();
	}

	/** Obtiene el identificador de la maquinaria. */
	public int getId() {
		return id;
	}
	/** Establece el identificador de la maquinaria. */
	public void setId(int id) {
		this.id = id;
	}
	/** Obtiene el nombre de la maquinaria. */
	public String getNombre() {
		return nombre;
	}
	/** Establece el nombre de la maquinaria. */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/** Obtiene el apellido. */
	public String getApellido() {
		return apellido;
	}
	/** Establece el apellido. */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/** Obtiene el número de celular. */
	public String getNumeroCelular() {
		return numeroCelular;
	}
	/** Establece el número de celular. */
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	/** Obtiene el correo electrónico. */
	public String getGmail() {
		return gmail;
	}
	/** Establece el correo electrónico. */
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	/** Obtiene la marca de la maquinaria. */
	public String getMarca() {
		return marca;
	}
	/** Establece la marca de la maquinaria. */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/** Obtiene el modelo de la maquinaria. */
	public String getModelo() {
		return modelo;
	}
	/** Establece el modelo de la maquinaria. */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/** Obtiene el número de serie. */
	public String getNumeroSerie() {
		return numeroSerie;
	}
	/** Establece el número de serie. */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	/** Obtiene el tipo de maquinaria. */
	public String getTipoMaquinaria() {
		return tipoMaquinaria;
	}
	/** Establece el tipo de maquinaria. */
	public void setTipoMaquinaria(String tipoMaquinaria) {
		this.tipoMaquinaria = tipoMaquinaria;
	}
	/** Obtiene el año de fabricación. */
	public int getAnioFabricacion() {
		return anioFabricacion;
	}
	/** Establece el año de fabricación. */
	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	/** Obtiene el número de motor. */
	public String getNumeroMotor() {
		return numeroMotor;
	}
	/** Establece el número de motor. */
	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	/** Obtiene las horas de operación acumuladas. */
	public double getHorasOperacion() {
		return horasOperacion;
	}
	/** Establece las horas de operación acumuladas. */
	public void setHorasOperacion(double horasOperacion) {
		this.horasOperacion = horasOperacion;
	}
	/** Obtiene el kilometraje acumulado. */
	public double getKilometraje() {
		return kilometraje;
	}
	/** Establece el kilometraje acumulado. */
	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}
}
