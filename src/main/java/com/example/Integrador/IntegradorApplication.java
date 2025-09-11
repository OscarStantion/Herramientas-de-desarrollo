package com.example.Integrador;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntegradorApplication {
	 public static void main(String[] args) {
	        // Crear carpeta logs si no existe
	        File logDir = new File("logs");
	        if (!logDir.exists()) {
	            boolean created = logDir.mkdirs();
	            if(created) {
	                System.out.println("Carpeta 'logs' creada correctamente.");
	            } else {
	                System.err.println("No se pudo crear la carpeta 'logs'.");
	            }
	        }
	        
	        // Crear carpeta de backups si no existe
	        // Cambiar la ruta si modificaron backup.directory
	        File backupDir = new File("D:/Backups/PostgreSQL");  // ← Sincronizar con application.properties
	        if (!backupDir.exists()) {
	            boolean created = backupDir.mkdirs();
	            if(created) {
	                System.out.println("Carpeta de backups 'D:/Backups/PostgreSQL' creada correctamente.");
	            } else {
	                System.err.println("No se pudo crear la carpeta de backups.");
	            }
	        }

	        SpringApplication.run(IntegradorApplication.class, args);
	    }



}
