# Integrador - Sistema de Gestión de Mantenimiento

[![CI - Integración Continua](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/ci.yml/badge.svg)](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/ci.yml)
[![Code Quality](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/code-quality.yml/badge.svg)](https://github.com/OscarStantion/Herramientas-de-desarrollo/actions/workflows/code-quality.yml)

## Descripción

Sistema de gestión de mantenimiento desarrollado con Spring Boot 3.5.0 y Java 21.

## Tecnologías

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Security**
- **Spring Data JPA**
- **Thymeleaf**
- **PostgreSQL / H2 Database**
- **Gradle**

##  Integración Continua

Este proyecto utiliza **GitHub Actions** para CI/CD:

-  Compilación automática en cada push
-  Ejecución de tests unitarios
-  Análisis de calidad de código
-  Generación de artefactos JAR
-  Reportes de tests

### Workflows configurados:

1. **CI - Integración Continua** (`.github/workflows/ci.yml`)
   - Compila el proyecto
   - Ejecuta tests
   - Genera artefactos JAR

2. **Code Quality** (`.github/workflows/code-quality.yml`)
   - Análisis de calidad de código
   - Verificación de dependencias

##  Instalación y Ejecución

### Requisitos previos
- Java 21
- Gradle 8.x (incluido wrapper)

### Clonar repositorio
```bash
git clone https://github.com/OscarStantion/Herramientas-de-desarrollo.git
cd Herramientas-de-desarrollo
```

### Compilar
```bash
./gradlew build
```

### Ejecutar tests
```bash
./gradlew test
```

### Ejecutar aplicación
```bash
./gradlew bootRun
```

La aplicación estará disponible en: `http://localhost:8080`

##  Testing

Los tests se ejecutan automáticamente en cada push mediante GitHub Actions.
Para ejecutarlos localmente:

```bash
./gradlew test
```

Los reportes de tests se generan en: `build/reports/tests/test/index.html`

##  Estructura del Proyecto

```
src/
├── main/
│   ├── java/          # Código fuente
│   └── resources/     # Recursos, templates, static
└── test/
    └── java/          # Tests unitarios
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
