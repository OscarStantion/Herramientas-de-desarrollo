package com.example.Integrador;

// Mantenimiento correctivo
public class MantenimientoCorrectivo implements Mantenimiento {
    @Override
    // Descripción del servicio
    public String getDescripcion() {
        return "Reparación o sustitución de equipos que han fallado.";
    }

    @Override
    // Coste estimado
    public double getCosto() {
        return 400.0;
    }

    @Override
    // Duración en días
    public int getDuracionDias() {
        return 2;
    }
}
