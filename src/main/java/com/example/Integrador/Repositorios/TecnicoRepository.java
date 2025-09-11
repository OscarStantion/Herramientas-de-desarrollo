package com.example.Integrador.Repositorios;

import java.util.Optional;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Integrador.Entidades.Tecnico;


public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    // Puedes agregar métodos personalizados si los necesitas
    List<Tecnico> findByEspecialidad(String especialidad);
    Optional<Tecnico> findByUsuario(String usuario);
    public Tecnico findByNombre(String nombre); 


    Optional<Tecnico> findByEmail(String email);

}