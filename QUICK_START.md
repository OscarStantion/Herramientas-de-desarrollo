# ⚡ INICIO RÁPIDO - Entrega Continua (CD)

## 🎯 ¿Qué cambió en tu proyecto?

**Antes**: Solo tenías CI (compilar + testear)  
**Ahora**: Tienes CD completo (desde código hasta despliegue) 🚀

---

## 🚀 Pruébalo AHORA (3 pasos)

### Paso 1: Instala Docker Desktop
Si no lo tienes:
1. Descarga: https://www.docker.com/products/docker-desktop
2. Instala y reinicia tu PC
3. Abre Docker Desktop (debe estar corriendo)

### Paso 2: Levanta la aplicación
```powershell
# Opción A: Con el helper script (recomendado)
.\docker-helper.ps1 start

# Opción B: Directo con docker-compose
docker-compose up -d
```

### Paso 3: Verifica que funcione
```powershell
# Ver estado
.\docker-helper.ps1 status

# Ver salud
.\docker-helper.ps1 health

# Abrir en navegador
.\docker-helper.ps1 open
```

✅ Tu app está corriendo en: http://localhost:8081

---

## 📚 Documentación completa

| Documento | Para qué sirve |
|-----------|----------------|
| [DOCKER_GUIDE.md](.github/DOCKER_GUIDE.md) | Guía completa de Docker |
| [CD_PRESENTATION_GUIDE.md](.github/CD_PRESENTATION_GUIDE.md) | Cómo presentar al profesor |
| [CD_IMPLEMENTATION_SUMMARY.md](.github/CD_IMPLEMENTATION_SUMMARY.md) | Resumen técnico |
| [README.md](README.md) | Documentación principal |

---

## 🎓 Para tu clase

### Conceptos implementados:
1. ✅ **Pipeline/Orquestador** → GitHub Actions
2. ✅ **Contenedores** → Docker
3. ✅ **Registro de imágenes** → Docker Hub (opcional)
4. ✅ **IaC** → docker-compose.yml
5. ✅ **Observabilidad** → Spring Boot Actuator
6. ✅ **Multi-ambiente** → Variables de entorno

### Demo rápida (2 minutos):
```powershell
# 1. Mostrar estado inicial
docker ps

# 2. Levantar todo
.\docker-helper.ps1 start

# 3. Ver salud
.\docker-helper.ps1 health

# 4. Abrir navegador
.\docker-helper.ps1 open
```

---

## 🆘 Solución rápida de problemas

**❌ "docker-compose no se reconoce"**
→ Instala Docker Desktop y reinicia terminal

**❌ "Puerto 8081 en uso"**
```powershell
# Ver qué lo usa
netstat -ano | findstr :8081

# Matar proceso
taskkill /PID <número> /F
```

**❌ "Error de conexión a base de datos"**
```powershell
# Reconstruir desde cero
docker-compose down -v
docker-compose up -d
```

**❌ "La app no responde"**
```powershell
# Ver logs
.\docker-helper.ps1 logs
```

---

## 📊 Helper Script - Comandos disponibles

```powershell
.\docker-helper.ps1 start      # Iniciar app + DB
.\docker-helper.ps1 stop       # Detener todo
.\docker-helper.ps1 restart    # Reiniciar
.\docker-helper.ps1 logs       # Ver logs en tiempo real
.\docker-helper.ps1 status     # Ver estado
.\docker-helper.ps1 health     # Check de salud
.\docker-helper.ps1 open       # Abrir navegador
.\docker-helper.ps1 clean      # Limpiar todo
.\docker-helper.ps1 build      # Reconstruir imagen
```

---

## 🔥 Siguiente paso: Hacer commit

```powershell
# Ver archivos nuevos
git status

# Agregar todos los archivos nuevos
git add .

# Hacer commit
git commit -m "feat: Implementar Entrega Continua (CD) con Docker"

# Subir a GitHub
git push origin main
```

Esto disparará automáticamente:
1. ✅ Workflow CI (build + test)
2. ✅ Workflow Docker (build imagen)
3. 🐳 Publicación en Docker Hub (si configuraste secrets)

---

## 🎯 Configurar Docker Hub (opcional pero recomendado)

Para que tus imágenes se publiquen automáticamente:

1. **Crea cuenta**: https://hub.docker.com
2. **Genera token**: Account Settings → Security → New Access Token
3. **Configura en GitHub**:
   - Ve a tu repo → Settings → Secrets
   - Crea `DOCKER_USERNAME` (tu usuario)
   - Crea `DOCKER_PASSWORD` (el token)

Después del próximo push, verás tu imagen en Docker Hub 🎉

---

## 💡 Tips finales

✅ **Practica antes de presentar**
- Ejecuta `.\docker-helper.ps1 start` varias veces
- Familiarízate con los comandos
- Prueba abrir los health checks

✅ **Ten los navegadores listos**
- http://localhost:8081
- http://localhost:8081/actuator/health
- Tu repo en GitHub (pestaña Actions)

✅ **Conoce tu flujo**
1. Git push → 2. GitHub Actions → 3. Docker Hub → 4. Deploy

---

**¿Dudas?** Lee la documentación completa:
- 📘 [DOCKER_GUIDE.md](.github/DOCKER_GUIDE.md)
- 🎤 [CD_PRESENTATION_GUIDE.md](.github/CD_PRESENTATION_GUIDE.md)

**¡A romperla en tu presentación! 🚀**
