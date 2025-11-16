# 🐳 Guía de Entrega Continua (CD) - Docker

## 📋 ¿Qué se implementó?

### ✅ Herramientas de CD agregadas:

1. **Contenedores (Docker)** 🐳
   - Dockerfile multi-stage para optimización
   - docker-compose.yml para levantar app + base de datos
   
2. **Pipeline de Despliegue** 🚀
   - Workflow para crear y publicar imágenes Docker
   - Push automático a Docker Hub en cada commit a main
   
3. **Observabilidad** 📊
   - Health checks con Spring Boot Actuator
   - Endpoints de monitoreo (/actuator/health)
   
4. **Gestión de Ambientes** 🌍
   - Variables de entorno para dev/prod
   - Configuración flexible con application-prod.properties

---

## 🚀 Cómo usar Docker en tu proyecto

### Opción 1: Docker Compose (Recomendado para desarrollo)

```bash
# Levantar toda la aplicación (app + base de datos)
docker-compose up -d

# Ver logs
docker-compose logs -f

# Detener todo
docker-compose down

# Reconstruir y levantar
docker-compose up --build -d
```

Tu aplicación estará disponible en: http://localhost:8081

### Opción 2: Docker manual

```bash
# Construir la imagen
docker build -t integrador-app .

# Ejecutar con PostgreSQL externo
docker run -p 8081:8081 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/DB_Integrador \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=YES \
  integrador-app
```

---

## 🔧 Configuración de Docker Hub (Para CD automático)

Para que el workflow de Docker funcione, necesitas configurar secretos en GitHub:

1. Ve a tu repositorio en GitHub
2. **Settings** → **Secrets and variables** → **Actions**
3. Click en **New repository secret**
4. Crea estos 2 secretos:

| Secret Name | Valor | Dónde obtenerlo |
|-------------|-------|-----------------|
| `DOCKER_USERNAME` | Tu usuario de Docker Hub | https://hub.docker.com |
| `DOCKER_PASSWORD` | Token de acceso | Docker Hub → Account Settings → Security → New Access Token |

**Pasos para crear el token:**
1. Inicia sesión en https://hub.docker.com
2. Click en tu nombre → **Account Settings**
3. **Security** → **New Access Token**
4. Nombre: "GitHub Actions"
5. Permisos: **Read, Write, Delete**
6. Copia el token y pégalo en `DOCKER_PASSWORD`

---

## 📊 Health Checks y Monitoreo

Tu aplicación ahora tiene endpoints de salud:

- **Health general**: http://localhost:8081/actuator/health
- **Info de la app**: http://localhost:8081/actuator/info
- **Métricas**: http://localhost:8081/actuator/metrics

Ejemplo de respuesta:
```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "PostgreSQL",
        "validationQuery": "isValid()"
      }
    },
    "diskSpace": {
      "status": "UP"
    }
  }
}
```

---

## 🎯 Flujo de CD implementado

```
┌─────────────┐
│  Git Push   │
│   to main   │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│ GitHub Actions  │
│   CI Workflow   │
└──────┬──────────┘
       │
       ├─► Build & Test ✅
       │
       ▼
┌─────────────────┐
│ Docker Build    │
│   Workflow      │
└──────┬──────────┘
       │
       ├─► Build Docker Image 🐳
       ├─► Push to Docker Hub 📦
       │
       ▼
┌─────────────────┐
│   Disponible    │
│  para Deploy    │
└─────────────────┘
```

---

## 💡 Comandos útiles

### Docker
```bash
# Ver contenedores corriendo
docker ps

# Ver logs de un contenedor específico
docker logs integrador-app -f

# Entrar a un contenedor
docker exec -it integrador-app sh

# Ver imágenes locales
docker images

# Limpiar todo (cuidado!)
docker system prune -a
```

### Docker Compose
```bash
# Solo base de datos
docker-compose up postgres -d

# Ver estado de servicios
docker-compose ps

# Reiniciar un servicio
docker-compose restart app

# Ver uso de recursos
docker stats
```

---

## 🎓 Para tu presentación

Puedes explicar que implementaste:

1. **Contenedores con Docker** → Empaqueta la aplicación de forma portable
2. **Pipeline de CD** → Automatiza la creación y distribución de imágenes
3. **Health Checks** → Monitoreo de salud de la aplicación
4. **Variables de entorno** → Configuración flexible para diferentes ambientes
5. **Orquestación** → Docker Compose para manejar múltiples servicios

### Conceptos que cubriste:

- ✅ **Orquestador/Pipeline**: GitHub Actions
- ✅ **Gestor de artefactos**: Docker Hub (imágenes) + GitHub Releases (JARs)
- ✅ **Contenedores**: Docker
- ✅ **Observabilidad**: Spring Boot Actuator con health checks
- ✅ **Despliegue repetible**: Docker Compose

---

## 🐛 Solución de problemas

**Error: Puerto 8081 en uso**
```bash
# Windows
netstat -ano | findstr :8081
taskkill /PID <PID> /F

# Usar otro puerto
docker-compose up -e SERVER_PORT=8082
```

**Error: No se conecta a la base de datos**
```bash
# Verificar que PostgreSQL esté corriendo
docker-compose ps postgres

# Ver logs de la base de datos
docker-compose logs postgres
```

**Reconstruir desde cero**
```bash
docker-compose down -v
docker-compose up --build
```

---

## 📚 Recursos adicionales

- [Docker Documentation](https://docs.docker.com/)
- [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
- [Docker Compose Reference](https://docs.docker.com/compose/compose-file/)

---

**Fecha de implementación**: 16 de noviembre de 2025
**Versión**: 1.0
