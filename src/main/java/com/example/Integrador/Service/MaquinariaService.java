package com.example.Integrador.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Integrador.DTOs.DTOMaquinaria;
import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Repositorios.MaquinariaRepository;

@Service
public class MaquinariaService {

	@Autowired
	private MaquinariaRepository maquinariaRepository;
	
	public Maquinaria guardarMaquinaria(DTOMaquinaria dto) {
	    Maquinaria maquinaria = new Maquinaria();
	    maquinaria.setNombre(dto.getNombre());
	    maquinaria.setApellido(dto.getApellido());
	    maquinaria.setNumeroCelular(dto.getNumeroCelular());
	    maquinaria.setGmail(dto.getGmail());
	    maquinaria.setMarca(dto.getMarca());
	    maquinaria.setModelo(dto.getModelo());
	    maquinaria.setNumeroSerie(dto.getNumeroSerie());
	    maquinaria.setTipoMaquinaria(dto.getTipoMaquinaria());
	    maquinaria.setAnioFabricacion(dto.getAnioFabricacion());
	    maquinaria.setNumeroMotor(dto.getNumeroMotor());
	    maquinaria.setHorasOperacion(dto.getHorasOperacion());
	    maquinaria.setKilometraje(dto.getKilometraje());

	    // Guardar y devolver la entidad con ID generado
	    return maquinariaRepository.save(maquinaria);
	}
	
	public List<Maquinaria> obtenerTodos() {
        return maquinariaRepository.findAll();
    }
	
	public Maquinaria obtenerUltimaMaquinaria() {
        return maquinariaRepository.findTopByOrderByIdDesc();
    }
}