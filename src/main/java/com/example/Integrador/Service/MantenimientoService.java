package com.example.Integrador.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Integrador.DTOs.SeleccionMantenimientoDTO;
import com.example.Integrador.Entidades.MantenimientoSeleccionado;
import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Repositorios.MantenimientoRepository;

@Service
public class MantenimientoService {

	@Autowired
	private MantenimientoRepository mantenimientoReopository;
	
	public void guardar (SeleccionMantenimientoDTO dto) {
		MantenimientoSeleccionado man = new MantenimientoSeleccionado();
		man.setFechaSalida(dto.getFechaSalida());
		//String resultado = String.join(",", dto.getTiposSeleccionados());
		//man.setTipos(resultado);
		mantenimientoReopository.save(man);
	}
	
	public MantenimientoRepository obtenerUltimaMaquinaria() {
        return mantenimientoReopository.findTopByOrderByIdDesc();
    }
}
