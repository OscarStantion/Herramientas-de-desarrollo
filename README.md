# Gusanito (Snake)

Juego clásico de gusanito hecho con HTML5 Canvas, CSS y JavaScript puro. Sin dependencias.

## Controles
- Movimiento: Flechas o WASD
- Pausa/Reanudar: Espacio
- Reiniciar: R o botón "Reiniciar"

## Cómo ejecutar
Abre el archivo `index.html` en tu navegador. No requiere servidor.

Opcional: si quieres servirlo localmente (útil para móviles), puedes abrir una consola PowerShell en la carpeta y ejecutar un servidor simple con Python:

```powershell
# Si tienes Python 3 instalado
python -m http.server 5500
# Luego abre http://localhost:5500
```

## Notas
- El puntaje más alto se guarda en `localStorage` del navegador.
- El tablero es 20x20 celdas (480px / 24px).
- La velocidad aumenta ligeramente al comer.
