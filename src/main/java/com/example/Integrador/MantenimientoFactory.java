package com.example.Integrador;
import java.util.ArrayList;
import java.util.List;
// Clase base para los mantenimientos
public class MantenimientoFactory {

    public static Mantenimiento crearMantenimiento(String tipo) {
        switch (tipo.toLowerCase()) {
            case "preventivo":
                return new MantenimientoPreventivo();
            case "correctivo":
                return new MantenimientoCorrectivo();
            case "predictivo":
                return new MantenimientoPredictivo();
            default:
                throw new IllegalArgumentException("Tipo de mantenimiento desconocido: " + tipo);
        }
    }

    public static List<Mantenimiento> crearMantenimientos(List<String> tipos) {
        List<Mantenimiento> lista = new ArrayList<>();
        for (String tipo : tipos) {
            lista.add(crearMantenimiento(tipo));
        }
        return lista;
    }
}
