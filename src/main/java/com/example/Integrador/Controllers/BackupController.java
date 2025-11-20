package com.example.Integrador.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Integrador.Service.DatabaseBackupService;

// Controlador para operaciones de backup
// Rutas API backup
@RestController
@RequestMapping("/api/backup")
public class BackupController {
    
    @Autowired
    // Servicio base datos
    private DatabaseBackupService backupService; // Servicio de backup // Servicio de backup
    
    // Crea backup manual de la BD
    // Crear backup manual
    @PostMapping("/manual")
    public ResponseEntity<String> createManualBackup() {
        try {
            String result = backupService.createManualBackup();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Error al crear backup: " + e.getMessage());
        }
    }
    
    // Consulta estado del servicio backup
    // Estado servicio backup
    @GetMapping("/status")
    public ResponseEntity<String> getBackupStatus() {
        return ResponseEntity.ok("Servicio de backup automático está activo. " +
                "Los backups se ejecutan cada domingo a las 2:00 AM");
    }
}
