# 📚 Guía de GitHub Actions - Integración Continua

## ¿Qué es CI (Continuous Integration)?

La Integración Continua es una práctica de desarrollo donde los desarrolladores integran código en un repositorio compartido frecuentemente. Cada integración se verifica mediante una compilación automática y tests.

## Estructura de GitHub Actions

### Ubicación
Los workflows se configuran en: `.github/workflows/*.yml`

### Sintaxis básica

```yaml
name: Nombre del Workflow

on: [push, pull_request]  # Eventos que disparan el workflow

jobs:
  nombre-job:
    runs-on: ubuntu-latest  # Sistema operativo
    steps:
      - name: Paso 1
        run: comando
```

## 🔧 Workflows Configurados en este Proyecto

### 1. CI - Integración Continua (`ci.yml`)

**¿Cuándo se ejecuta?**
- En cada `push` a la rama `main`
- En cada `pull request` hacia `main`

**¿Qué hace?**
1. ✅ Descarga el código del repositorio
2. ✅ Configura Java 21
3. ✅ Da permisos al wrapper de Gradle
4. ✅ Compila el proyecto con `./gradlew build`
5. ✅ Ejecuta los tests con `./gradlew test`
6. ✅ Genera reportes de tests en formato JUnit
7. ✅ Sube el archivo JAR generado como artefacto
8. ✅ Sube el reporte HTML de tests

**Artefactos generados:**
- `integrador-app` - JAR compilado (disponible 7 días)
- `test-report` - Reporte HTML de tests (disponible 7 días)

### 2. Code Quality (`code-quality.yml`)

**¿Cuándo se ejecuta?**
- En cada `push` a la rama `main`
- En cada `pull request` hacia `main`

**¿Qué hace?**
1. ✅ Análisis de calidad de código
2. ✅ Verifica formato de código
3. ✅ Genera reporte de dependencias
4. ✅ Sube análisis como artefacto

## 🎯 Cómo funciona

### Flujo de trabajo típico:

```
┌─────────────┐
│  Git Push   │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│ GitHub detecta  │
│   el evento     │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Inicia runners  │
│   (máquinas     │
│    virtuales)   │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Ejecuta jobs    │
│   en paralelo   │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│  Reporta        │
│  resultados     │
└─────────────────┘
```

## 📊 Ver resultados

1. Ve a tu repositorio en GitHub
2. Click en la pestaña **"Actions"**
3. Verás la lista de workflows ejecutados
4. Click en cualquier ejecución para ver detalles
5. Click en un job para ver los logs de cada paso

## 🔴 Si falla un workflow

Los workflows pueden fallar por:
- ❌ Tests que no pasan
- ❌ Errores de compilación
- ❌ Problemas de dependencias
- ❌ Violaciones de calidad de código

**¿Qué hacer?**
1. Revisa los logs en la pestaña Actions
2. Identifica el paso que falló
3. Corrige el error localmente
4. Prueba ejecutando: `./gradlew test` o `./gradlew build`
5. Haz commit y push de la corrección
6. El workflow se ejecutará automáticamente de nuevo

## 🎨 Badges de Estado

Los badges en el README.md muestran el estado actual:

```markdown
[![CI](URL_AL_WORKFLOW/badge.svg)](URL_AL_WORKFLOW)
```

- 🟢 **Verde (passing)**: Todo OK
- 🔴 **Rojo (failing)**: Hay errores
- 🟡 **Amarillo (pending)**: En ejecución

## 💡 Comandos útiles de Gradle

```bash
# Compilar sin tests
./gradlew build -x test

# Solo ejecutar tests
./gradlew test

# Limpiar y compilar
./gradlew clean build

# Ver dependencias
./gradlew dependencies

# Ejecutar aplicación
./gradlew bootRun
```

## 🔐 Secretos y Variables de Entorno

Si necesitas usar secretos (API keys, passwords):

1. Ve a Settings → Secrets and variables → Actions
2. Click en "New repository secret"
3. Usa en el workflow:

```yaml
env:
  MI_SECRETO: ${{ secrets.MI_SECRETO }}
```

## 🚀 Próximos pasos (Avanzado)

### Agregar más funcionalidades:

1. **Code Coverage (Cobertura de código)**
   - Agregar JaCoCo para medir cobertura
   - Integrar con Codecov o Coveralls

2. **Deploy automático**
   - Deploy a Heroku, AWS, Azure
   - Deploy a Docker Hub

3. **Notificaciones**
   - Slack, Discord, Email
   - Solo en fallos

4. **Análisis de seguridad**
   - Snyk para vulnerabilidades
   - OWASP dependency check

5. **Performance testing**
   - JMeter, Gatling
   - Tests de carga

## 📖 Recursos adicionales

- [Documentación oficial GitHub Actions](https://docs.github.com/en/actions)
- [Marketplace de Actions](https://github.com/marketplace?type=actions)
- [Ejemplos de workflows](https://github.com/actions/starter-workflows)

## ❓ Preguntas frecuentes

**¿Cuánto cuesta GitHub Actions?**
- Para repos públicos: **GRATIS e ilimitado**
- Para repos privados: 2000 minutos/mes gratis

**¿Puedo ejecutar el workflow manualmente?**
Sí, agrega `workflow_dispatch` al trigger:
```yaml
on:
  push:
  workflow_dispatch:  # Permite ejecución manual
```

**¿Puedo probar localmente?**
Sí, usa [act](https://github.com/nektos/act) para simular GitHub Actions localmente.

**¿Cuánto tarda en ejecutarse?**
Típicamente 2-5 minutos para este proyecto. Depende de:
- Tamaño del proyecto
- Cantidad de tests
- Cache de dependencias
