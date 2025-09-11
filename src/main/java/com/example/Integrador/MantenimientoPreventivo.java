package com.example.Integrador;

public class MantenimientoPreventivo implements Mantenimiento {
    @Override
    public String getDescripcion() {
        return "Revisión y reparación de sistemas eléctricos, hidráulicos, motor, transmisión, chasis y cambio de carrilería.";
    }

    @Override
    public double getCosto() {
        return 200.0;
    }

    @Override
    public int getDuracionDias() {
        return 1;
    }
}
