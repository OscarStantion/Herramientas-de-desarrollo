package com.example.Integrador.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Integrador.Entidades.Maquinaria;


public interface MaquinariaRepository extends JpaRepository<Maquinaria, Integer> {

	Maquinaria findTopByOrderByIdDesc();

}
