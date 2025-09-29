package com.example.Integrador;
// Clase que implementa el mantenimiento predictivo, basado en la predicción de fallos mediante análisis de datos.
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
