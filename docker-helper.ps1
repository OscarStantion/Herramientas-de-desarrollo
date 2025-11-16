# 🚀 Script de ayuda para Docker - Integrador App
# Uso: .\docker-helper.ps1 [comando]

param(
    [Parameter(Position=0)]
    [string]$Comando = "help"
)

function Show-Banner {
    Write-Host ""
    Write-Host "╔═══════════════════════════════════════════╗" -ForegroundColor Cyan
    Write-Host "║   🐳 INTEGRADOR APP - Docker Helper      ║" -ForegroundColor Cyan
    Write-Host "║   Entrega Continua (CD) Helper            ║" -ForegroundColor Cyan
    Write-Host "╚═══════════════════════════════════════════╝" -ForegroundColor Cyan
    Write-Host ""
}

function Show-Help {
    Show-Banner
    Write-Host "Comandos disponibles:" -ForegroundColor Yellow
    Write-Host ""
    Write-Host "  start        " -NoNewline -ForegroundColor Green
    Write-Host "- Iniciar aplicación (app + base de datos)"
    Write-Host "  stop         " -NoNewline -ForegroundColor Red
    Write-Host "- Detener aplicación"
    Write-Host "  restart      " -NoNewline -ForegroundColor Magenta
    Write-Host "- Reiniciar aplicación"
    Write-Host "  logs         " -NoNewline -ForegroundColor Cyan
    Write-Host "- Ver logs en tiempo real"
    Write-Host "  status       " -NoNewline -ForegroundColor Blue
    Write-Host "- Ver estado de contenedores"
    Write-Host "  health       " -NoNewline -ForegroundColor DarkGreen
    Write-Host "- Verificar salud de la aplicación"
    Write-Host "  open         " -NoNewline -ForegroundColor Yellow
    Write-Host "- Abrir aplicación en navegador"
    Write-Host "  clean        " -NoNewline -ForegroundColor DarkRed
    Write-Host "- Limpiar todo (contenedores y volúmenes)"
    Write-Host "  build        " -NoNewline -ForegroundColor DarkYellow
    Write-Host "- Reconstruir imagen desde cero"
    Write-Host ""
    Write-Host "Ejemplos:" -ForegroundColor Yellow
    Write-Host "  .\docker-helper.ps1 start" -ForegroundColor Gray
    Write-Host "  .\docker-helper.ps1 logs" -ForegroundColor Gray
    Write-Host "  .\docker-helper.ps1 health" -ForegroundColor Gray
    Write-Host ""
}

function Start-App {
    Show-Banner
    Write-Host "🚀 Iniciando aplicación..." -ForegroundColor Green
    Write-Host ""
    docker-compose up -d
    Write-Host ""
    Write-Host "✅ Aplicación iniciada!" -ForegroundColor Green
    Write-Host "   📱 App: http://localhost:8081" -ForegroundColor Cyan
    Write-Host "   💚 Health: http://localhost:8081/actuator/health" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "Para ver logs: " -NoNewline -ForegroundColor Yellow
    Write-Host ".\docker-helper.ps1 logs" -ForegroundColor White
}

function Stop-App {
    Show-Banner
    Write-Host "🛑 Deteniendo aplicación..." -ForegroundColor Red
    docker-compose down
    Write-Host ""
    Write-Host "✅ Aplicación detenida" -ForegroundColor Green
}

function Restart-App {
    Show-Banner
    Write-Host "🔄 Reiniciando aplicación..." -ForegroundColor Magenta
    docker-compose restart
    Write-Host ""
    Write-Host "✅ Aplicación reiniciada" -ForegroundColor Green
}

function Show-Logs {
    Show-Banner
    Write-Host "📋 Mostrando logs (Ctrl+C para salir)..." -ForegroundColor Cyan
    Write-Host ""
    docker-compose logs -f
}

function Show-Status {
    Show-Banner
    Write-Host "📊 Estado de contenedores:" -ForegroundColor Blue
    Write-Host ""
    docker-compose ps
    Write-Host ""
    Write-Host "💾 Uso de recursos:" -ForegroundColor Blue
    docker stats --no-stream
}

function Check-Health {
    Show-Banner
    Write-Host "💚 Verificando salud de la aplicación..." -ForegroundColor Green
    Write-Host ""
    
    try {
        $response = Invoke-WebRequest -Uri "http://localhost:8081/actuator/health" -UseBasicParsing
        $json = $response.Content | ConvertFrom-Json
        
        if ($json.status -eq "UP") {
            Write-Host "✅ Aplicación: " -NoNewline -ForegroundColor Green
            Write-Host "FUNCIONANDO" -ForegroundColor Green
            Write-Host ""
            Write-Host "Componentes:" -ForegroundColor Cyan
            $json.components.PSObject.Properties | ForEach-Object {
                $name = $_.Name
                $status = $_.Value.status
                $color = if ($status -eq "UP") { "Green" } else { "Red" }
                Write-Host "  • $name : " -NoNewline
                Write-Host $status -ForegroundColor $color
            }
        } else {
            Write-Host "⚠️  Aplicación: " -NoNewline -ForegroundColor Yellow
            Write-Host "CON PROBLEMAS" -ForegroundColor Yellow
        }
    }
    catch {
        Write-Host "❌ Error: No se pudo conectar a la aplicación" -ForegroundColor Red
        Write-Host "   ¿Está corriendo? Intenta: .\docker-helper.ps1 start" -ForegroundColor Yellow
    }
    Write-Host ""
}

function Open-Browser {
    Show-Banner
    Write-Host "🌐 Abriendo aplicación en navegador..." -ForegroundColor Yellow
    Start-Process "http://localhost:8081"
    Start-Sleep -Seconds 1
    Write-Host "🩺 Abriendo health check..." -ForegroundColor Green
    Start-Process "http://localhost:8081/actuator/health"
    Write-Host ""
    Write-Host "✅ Navegador abierto" -ForegroundColor Green
}

function Clean-All {
    Show-Banner
    Write-Host "⚠️  ADVERTENCIA: Esto eliminará todos los contenedores y datos" -ForegroundColor Red
    $confirm = Read-Host "¿Estás seguro? (s/N)"
    
    if ($confirm -eq "s" -or $confirm -eq "S") {
        Write-Host ""
        Write-Host "🧹 Limpiando..." -ForegroundColor Yellow
        docker-compose down -v
        Write-Host ""
        Write-Host "✅ Todo limpiado" -ForegroundColor Green
    } else {
        Write-Host "❌ Cancelado" -ForegroundColor Yellow
    }
}

function Build-App {
    Show-Banner
    Write-Host "🔨 Reconstruyendo imagen desde cero..." -ForegroundColor Yellow
    Write-Host ""
    docker-compose build --no-cache
    Write-Host ""
    Write-Host "✅ Imagen reconstruida" -ForegroundColor Green
    Write-Host "Para iniciar: " -NoNewline -ForegroundColor Yellow
    Write-Host ".\docker-helper.ps1 start" -ForegroundColor White
}

# Ejecutar comando
switch ($Comando.ToLower()) {
    "start" { Start-App }
    "stop" { Stop-App }
    "restart" { Restart-App }
    "logs" { Show-Logs }
    "status" { Show-Status }
    "health" { Check-Health }
    "open" { Open-Browser }
    "clean" { Clean-All }
    "build" { Build-App }
    default { Show-Help }
}
