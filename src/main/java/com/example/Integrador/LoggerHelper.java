package com.example.Integrador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggerHelper {
    private static final Logger logger = LoggerFactory.getLogger(LoggerHelper.class);

    public static void logInfo(String mensaje) {
        logger.info(mensaje);
    }

    public static void logError(String mensaje, Exception ex) {
        logger.error(mensaje, ex);
    }
}