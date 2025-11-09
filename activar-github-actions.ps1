# Script para activar GitHub Actions en Windows PowerShell
# Ejecutar: .\activar-github-actions.ps1

Write-Host "============================================" -ForegroundColor Cyan
Write-Host "  Activando GitHub Actions - CI/CD" -ForegroundColor Cyan
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""

# Verificar si estamos en un repositorio git
if (-not (Test-Path .git)) {
    Write-Host "❌ Error: No estás en un repositorio git" -ForegroundColor Red
    exit 1
}

Write-Host "📋 Paso 1: Verificando archivos creados..." -ForegroundColor Yellow
$archivos = @(
    ".github\workflows\ci.yml",
    ".github\workflows\code-quality.yml",
    ".github\workflows\release.yml",
    ".github\GITHUB_ACTIONS_GUIDE.md",
    ".github\PASOS_PARA_ACTIVAR.md",
    "README.md"
)

foreach ($archivo in $archivos) {
    if (Test-Path $archivo) {
        Write-Host "  ✅ $archivo" -ForegroundColor Green
    } else {
        Write-Host "  ❌ $archivo (no encontrado)" -ForegroundColor Red
    }
}

Write-Host ""
Write-Host "📋 Paso 2: Mostrando estado de git..." -ForegroundColor Yellow
git status

Write-Host ""
Write-Host "📋 Paso 3: Agregando archivos..." -ForegroundColor Yellow
git add .github/
git add README.md

Write-Host ""
Write-Host "📋 Paso 4: Haciendo commit..." -ForegroundColor Yellow
$mensaje = "feat: Agregar GitHub Actions para CI/CD

- Agregar workflow de CI con compilación y tests
- Agregar workflow de análisis de calidad
- Agregar workflow de releases
- Agregar README con badges
- Agregar documentación completa de GitHub Actions"

git commit -m $mensaje

if ($LASTEXITCODE -eq 0) {
    Write-Host "  ✅ Commit exitoso" -ForegroundColor Green
} else {
    Write-Host "  ⚠️  No hay cambios para hacer commit o ya se hizo commit" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "📋 Paso 5: Subiendo a GitHub..." -ForegroundColor Yellow
Write-Host "  Ejecutando: git push origin main" -ForegroundColor Gray

git push origin main

if ($LASTEXITCODE -eq 0) {
    Write-Host "  ✅ Push exitoso" -ForegroundColor Green
    Write-Host ""
    Write-Host "============================================" -ForegroundColor Cyan
    Write-Host "  ✨ ¡GitHub Actions activado!" -ForegroundColor Green
    Write-Host "============================================" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "🔗 Ve a tu repositorio en GitHub:" -ForegroundColor Yellow
    Write-Host "   https://github.com/OscarStantion/Herramientas-de-desarrollo" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "👉 Luego ve a la pestaña 'Actions' para ver los workflows ejecutándose" -ForegroundColor Yellow
    Write-Host ""
} else {
    Write-Host "  ❌ Error al hacer push" -ForegroundColor Red
    Write-Host ""
    Write-Host "Posibles soluciones:" -ForegroundColor Yellow
    Write-Host "  1. Verifica tu conexión a internet" -ForegroundColor Gray
    Write-Host "  2. Verifica que tengas permisos en el repositorio" -ForegroundColor Gray
    Write-Host "  3. Haz pull primero: git pull origin main" -ForegroundColor Gray
    Write-Host "  4. Verifica tus credenciales de GitHub" -ForegroundColor Gray
}

Write-Host ""
Write-Host "Presiona cualquier tecla para salir..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
