# Dockerfile para aplicación Spring Boot
# Etapa 1: Build
FROM gradle:8.14-jdk21 AS build
WORKDIR /app

# Copiar archivos de configuración de Gradle
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY gradlew ./

# Descargar dependencias (se cachea si no cambian)
RUN ./gradlew dependencies --no-daemon

# Copiar el código fuente
COPY src ./src

# Compilar la aplicación
RUN ./gradlew build --no-daemon -x test

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Crear usuario no-root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el JAR desde la etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

# Exponer puerto 8081 (el que usa tu app)
EXPOSE 8081

# Variables de entorno con valores por defecto
ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8081/actuator/health || exit 1

# Comando de inicio
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
