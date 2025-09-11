package com.example.Integrador.Service;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DatabaseBackupService {
    
    private static final Logger logger = Logger.getLogger(DatabaseBackupService.class.getName());
    
    @Value("${spring.datasource.username}")
    private String dbUsername;
    
    @Value("${spring.datasource.password}")
    private String dbPassword;
    
    @Value("${backup.directory:D:/Backups/PostgreSQL}")
    private String backupDirectory;
    
    private static final String DATABASE_NAME = "DB_Integrador";
    
    // Ejecutar cada domingo a las 2:00 AM (backup semanal)
    @Scheduled(cron = "0 0 2 * * SUN")
    public void createWeeklyBackup() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String backupFileName = String.format("%s_backup_%s.sql", DATABASE_NAME, timestamp);
            String backupPath = backupDirectory + "/" + backupFileName;
            
            // Crear directorio si no existe
            new java.io.File(backupDirectory).mkdirs();
            
            // Comando pg_dump con ruta completa
            ProcessBuilder processBuilder = new ProcessBuilder(
                "C:\\Program Files\\PostgreSQL\\17\\bin\\pg_dump.exe",  // ← CAMBIAR AQUÍ
                "-h", "localhost",
                "-U", dbUsername,
                "-d", DATABASE_NAME,
                "-f", backupPath
            );
            
            // Configurar variable de entorno para la contraseña
            processBuilder.environment().put("PGPASSWORD", dbPassword);
            
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                logger.info("Backup creado exitosamente: " + backupFileName);
                cleanOldBackups();
            } else {
                logger.severe("Error al crear backup. Código de salida: " + exitCode);
            }
            
        } catch (IOException | InterruptedException e) {
            logger.severe("Error al ejecutar backup: " + e.getMessage());
        }
    }
    
    private void cleanOldBackups() {
        try {
            java.io.File backupDir = new java.io.File(backupDirectory);
            java.io.File[] files = backupDir.listFiles((dir, name) -> 
                name.startsWith(DATABASE_NAME + "_backup_") && name.endsWith(".sql"));
            
            if (files != null && files.length > 4) {
                // Ordenar por fecha de modificación (más antiguos primero)
                java.util.Arrays.sort(files, java.util.Comparator.comparingLong(java.io.File::lastModified));
                
                // Eliminar archivos antiguos, mantener solo los últimos 4
                for (int i = 0; i < files.length - 4; i++) {
                    if (files[i].delete()) {
                        logger.info("Backup antiguo eliminado: " + files[i].getName());
                    }
                }
            }
        } catch (Exception e) {
            logger.warning("Error al limpiar backups antiguos: " + e.getMessage());
        }
    }
    
    // Método para ejecutar backup manualmente
    public String createManualBackup() {
        try {
            createWeeklyBackup();
            return "Backup manual iniciado exitosamente";
        } catch (Exception e) {
            return "Error al crear backup manual: " + e.getMessage();
        }
    }
}
