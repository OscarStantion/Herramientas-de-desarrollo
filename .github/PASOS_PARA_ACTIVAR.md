# 🚀 Pasos para Activar GitHub Actions

## 📝 Resumen de archivos creados

Se han creado los siguientes archivos para implementar CI/CD con GitHub Actions:

```
.github/
├── workflows/
│   ├── ci.yml              # Workflow principal de CI
│   ├── code-quality.yml    # Análisis de calidad
│   └── release.yml         # Crear releases (opcional)
├── GITHUB_ACTIONS_GUIDE.md # Guía completa de GitHub Actions
└── PASOS_PARA_ACTIVAR.md   # Este archivo

README.md                    # README con badges de estado
```

## 🔧 Paso 1: Revisar los archivos creados

Abre y revisa cada archivo para entender qué hace. Los comentarios en los archivos YAML explican cada paso.

## 📤 Paso 2: Hacer commit y push

### Opción A: Usando VS Code

1. Abre el panel de **Source Control** (Ctrl+Shift+G)
2. Verás todos los archivos nuevos
3. Escribe un mensaje de commit: "feat: Agregar GitHub Actions para CI/CD"
4. Click en ✓ **Commit**
5. Click en **Sync Changes** o **Push**

### Opción B: Usando Terminal en VS Code

```bash
# Ver archivos nuevos
git status

# Agregar todos los archivos nuevos
git add .github/ README.md

# Hacer commit
git commit -m "feat: Agregar GitHub Actions para CI/CD"

# Subir al repositorio
git push origin main
```

## ✅ Paso 3: Verificar que funciona

1. Ve a GitHub: https://github.com/OscarStantion/Herramientas-de-desarrollo
2. Click en la pestaña **"Actions"**
3. Deberías ver los workflows ejecutándose
4. Espera unos minutos a que terminen

### ¿Qué verás?

- 🟡 Círculo amarillo: Ejecutándose
- 🟢 Check verde: Éxito
- 🔴 X roja: Error (necesita corrección)

## 🐛 Paso 4: Si hay errores

### Error común: Tests fallando

Si los tests fallan:

```bash
# Ejecuta los tests localmente primero
./gradlew test

# Si hay errores, corrígelos
# Luego vuelve a hacer commit y push
```

### Error común: Permisos de gradlew

Si GitHub Actions no puede ejecutar gradlew:

```bash
# En Windows (Git Bash o PowerShell con WSL)
git update-index --chmod=+x gradlew
git commit -m "fix: Agregar permisos de ejecución a gradlew"
git push
```

### Error común: No se encuentra Java

Esto no debería pasar porque el workflow instala Java 21 automáticamente.

## 🎯 Paso 5: Crear tu primer Pull Request (PR)

Para ver GitHub Actions en acción:

1. Crea una nueva rama:
```bash
git checkout -b feature/mi-nueva-funcionalidad
```

2. Haz algunos cambios en el código

3. Commit y push:
```bash
git add .
git commit -m "feat: Agregar nueva funcionalidad"
git push origin feature/mi-nueva-funcionalidad
```

4. Ve a GitHub y crea un Pull Request

5. Verás que GitHub Actions se ejecuta automáticamente en el PR

6. No podrás hacer merge si los tests fallan (buena práctica!)

## 📊 Paso 6: Ver los badges

Después del primer push exitoso:

1. Ve a tu README.md en GitHub
2. Los badges mostrarán el estado:
   - 🟢 **passing** si todo OK
   - 🔴 **failing** si hay errores

## 🎓 Paso 7: Presentar al docente

Puedes mostrar:

1. **La pestaña Actions** con los workflows ejecutándose
2. **Los logs detallados** de cada paso
3. **Los artefactos generados** (JAR, reportes)
4. **Los badges** en el README
5. **Un Pull Request** donde se ejecutan los checks automáticos

## 🚀 Paso 8: (Opcional) Crear un Release

Cuando quieras crear una versión oficial:

```bash
# Crear un tag de versión
git tag -a v1.0.0 -m "Primera versión oficial"

# Subir el tag
git push origin v1.0.0
```

Esto activará el workflow de release y creará una release en GitHub con el JAR.

## 💡 Consejos

### Para el docente

Puedes explicar:
- ✅ Qué es CI/CD y por qué es importante
- ✅ Cómo GitHub Actions automatiza el proceso
- ✅ Cómo previene errores antes de hacer merge
- ✅ Cómo genera artefactos automáticamente
- ✅ La diferencia entre workflows, jobs y steps

### Mejoras futuras

1. **Agregar code coverage** (cobertura de tests)
2. **Deploy automático** a un servidor
3. **Notificaciones** en Discord/Slack
4. **Análisis de seguridad** de dependencias
5. **Tests de integración** adicionales

## 📚 Recursos para aprender más

- [GitHub Actions - Documentación oficial](https://docs.github.com/en/actions)
- [Awesome GitHub Actions](https://github.com/sdras/awesome-actions)
- [GitHub Actions Tutorial](https://www.youtube.com/results?search_query=github+actions+tutorial)

## ❓ Preguntas frecuentes

**P: ¿Necesito configurar algo en GitHub?**
R: No, solo hacer push de los archivos. GitHub detecta automáticamente los workflows en `.github/workflows/`

**P: ¿Cuánto tarda la primera ejecución?**
R: 3-5 minutos. Las siguientes son más rápidas gracias al cache.

**P: ¿Puedo desactivar un workflow?**
R: Sí, en GitHub → Actions → Selecciona el workflow → Disable workflow

**P: ¿Costo?**
R: Gratis para repositorios públicos. Repos privados tienen 2000 minutos gratis/mes.

**P: ¿Puedo ver los artefactos generados?**
R: Sí, en la página de ejecución del workflow, sección "Artifacts"

---

## ✨ ¡Listo!

Ahora tu proyecto tiene:
- ✅ Integración Continua automatizada
- ✅ Tests automáticos en cada push
- ✅ Análisis de calidad de código
- ✅ Generación de artefactos
- ✅ Badges de estado
- ✅ Documentación completa

**¡Éxito con tu curso! 🎓**
