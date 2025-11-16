# Integrador - Sistema de Gestión de Mantenimiento

[![CI - Integración Continua](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/ci.yml/badge.svg)](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/ci.yml)
[![Code Quality](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/code-quality.yml/badge.svg)](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/code-quality.yml)
[![Docker Build](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/docker-build.yml/badge.svg)](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/docker-build.yml)

## Descripción

Sistema de gestión de mantenimiento desarrollado con Spring Boot 3.5.0 y Java 21, con soporte para contenedores Docker y despliegue continuo.

## Tecnologías

- **Java 21**
- **Spring Boot 3.5.0**
  - Spring Security
  - Spring Data JPA
  - Spring Boot Actuator (Health Checks)
- **Thymeleaf**
- **PostgreSQL / H2 Database**
- **Gradle 8.14**
- **Docker & Docker Compose** 🐳

## 🚀 CI/CD (Integración y Entrega Continua)

Este proyecto utiliza **GitHub Actions** para CI/CD completo:

### ✅ Integración Continua (CI)
-  Compilación automática en cada push
-  Ejecución de tests unitarios
-  Análisis de calidad de código
-  Generación de artefactos JAR
-  Reportes de tests

### 🐳 Entrega Continua (CD)
-  Build automático de imágenes Docker
-  Push a Docker Hub en cada commit a main
-  Health checks y monitoreo con Actuator
-  Variables de entorno para múltiples ambientes

### Workflows configurados:

1. **CI - Integración Continua** (`.github/workflows/ci.yml`)
   - Compila el proyecto
   - Ejecuta tests
   - Genera artefactos JAR

2. **Code Quality** (`.github/workflows/code-quality.yml`)
   - Análisis de calidad de código
   - Verificación de dependencias

3. **Docker Build & Push** (`.github/workflows/docker-build.yml`)
   - Construye imagen Docker
   - Publica en Docker Hub
   - Versionado automático

##  Instalación y Ejecución

### Opción 1: Con Docker (Recomendado) 🐳

**Requisitos:**
- Docker Desktop
- Docker Compose

```bash
# Clonar repositorio
git clone https://github.com/OscarStantion/Herramientas-de-desarrollo.git
cd Herramientas-de-desarrollo

# Levantar toda la aplicación (app + PostgreSQL)
docker-compose up -d

# Ver logs
docker-compose logs -f
```

La aplicación estará disponible en: `http://localhost:8081`

**📖 [Ver guía completa de Docker](.github/DOCKER_GUIDE.md)**

### Opción 2: Tradicional (Sin Docker)

**Requisitos:**
- Java 21
- Gradle 8.x (incluido wrapper)
- PostgreSQL 17

```bash
# Clonar repositorio
git clone https://github.com/OscarStantion/Herramientas-de-desarrollo.git
cd Herramientas-de-desarrollo

# Compilar
./gradlew build

# Ejecutar tests
./gradlew test

# Ejecutar aplicación
./gradlew bootRun
```

La aplicación estará disponible en: `http://localhost:8081`

## 🧪 Testing

Los tests se ejecutan automáticamente en cada push mediante GitHub Actions.
Para ejecutarlos localmente:

```bash
./gradlew test
```

Los reportes de tests se generan en: `build/reports/tests/test/index.html`

## 📊 Monitoreo y Health Checks

La aplicación incluye Spring Boot Actuator para observabilidad:

- **Health Check**: http://localhost:8081/actuator/health
- **Info**: http://localhost:8081/actuator/info
- **Metrics**: http://localhost:8081/actuator/metrics

Ejemplo de respuesta de health:
```json
{
  "status": "UP",
  "components": {
    "db": { "status": "UP" },
    "diskSpace": { "status": "UP" }
  }
}
```

##  Estructura del Proyecto

```
.
├── src/
│   ├── main/
│   │   ├── java/              # Código fuente
│   │   └── resources/         
│   │       ├── application.properties
│   │       └── application-prod.properties  # Config para Docker
│   └── test/
│       └── java/              # Tests unitarios
├── .github/
│   ├── workflows/             # Workflows CI/CD
│   └── DOCKER_GUIDE.md        # Guía de Docker
├── Dockerfile                 # Imagen Docker multi-stage
├── docker-compose.yml         # Orquestación de servicios
└── build.gradle.kts           # Configuración Gradle
```

##  Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

Los workflows de CI se ejecutarán automáticamente en tu PR.

##  Licencia

Este proyecto es parte de un curso de Herramientas de Desarrollo.

##  Autores

- Oscar Stantion y KingcaraKong - [@OscarStantion](https://github.com/OscarStantion)
