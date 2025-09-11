package com.example.Integrador;

public class MantenimientoPredictivo implements Mantenimiento {
    @Override
    public String getDescripcion() {
        return "Predicción de fallos basada en datos para planificar mantenimiento.";
    }

    @Override
    public double getCosto() {
        return 300.0;
    }

    @Override
    public int getDuracionDias() {
        return 1;
    }
}
