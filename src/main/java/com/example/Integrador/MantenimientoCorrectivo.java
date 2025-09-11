package com.example.Integrador;
public class MantenimientoCorrectivo implements Mantenimiento {
    @Override
    public String getDescripcion() {
        return "Reparación o sustitución de equipos que han fallado.";
    }

    @Override
    public double getCosto() {
        return 400.0;
    }

    @Override
    public int getDuracionDias() {
        return 2;
    }
}
