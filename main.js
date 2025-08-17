'use strict';
(function(){
  // Configuración
  const CANVAS = document.getElementById('game');
  const CTX = CANVAS.getContext('2d');
  const UI = {
    score: document.getElementById('score'),
    best: document.getElementById('best'),
    pause: document.getElementById('btn-pause'),
    restart: document.getElementById('btn-restart'),
    up: document.getElementById('btn-up'),
    down: document.getElementById('btn-down'),
    left: document.getElementById('btn-left'),
    right: document.getElementById('btn-right'),
    speed: document.getElementById('speed'),
  };

  // Parámetros del juego
  const CELL = 24; // tamaño de celda
  const COLS = CANVAS.width / CELL; // 480/24 = 20
  const ROWS = CANVAS.height / CELL; // 20
  // Perfiles de velocidad
  const SPEED_PROFILES = {
    lento:  { start: 200, min: 120, accel: 3 },
    normal: { start: 160, min: 90,  accel: 4 },
    rapido: { start: 120, min: 70,  accel: 5 },
    insano: { start: 90,  min: 55,  accel: 6 },
  };
  let selectedProfile = localStorage.getItem('snakeSpeedProfile') || 'lento';
  if (!SPEED_PROFILES[selectedProfile]) selectedProfile = 'lento';
  // Reflejar selección en UI si existe el selector
  if (UI.speed) UI.speed.value = selectedProfile;
  function getProfile(){ return SPEED_PROFILES[selectedProfile]; }

  // Estado del juego
  let state = {
    snake: [{x:10,y:10}],
    dir: {x:1,y:0},
    nextDir: {x:1,y:0},
    food: {x: 14, y: 10},
    score: 0,
    best: Number(localStorage.getItem('bestScore')||0),
    tick: getProfile().start,
    running: true,
    lost: false,
    grow: 0,
  };
  UI.best.textContent = state.best;

  // Utilidades
  const randInt = (min, max) => Math.floor(Math.random()*(max-min+1))+min;
  const eq = (a,b) => a.x===b.x && a.y===b.y;
  const inBounds = (p) => p.x>=0 && p.x<COLS && p.y>=0 && p.y<ROWS;

  function placeFood(){
    let p;
    do {
      p = { x: randInt(0, COLS-1), y: randInt(0, ROWS-1) };
    } while(state.snake.some(s => eq(s,p)));
    state.food = p;
  }

  function reset(){
    state.snake = [{x:10,y:10}];
    state.dir = {x:1,y:0};
    state.nextDir = {x:1,y:0};
    state.score = 0;
  state.tick = getProfile().start;
    state.running = true;
    state.lost = false;
    state.grow = 0;
    placeFood();
    UI.score.textContent = '0';
  }

  function setDir(dx,dy){
    // Evitar giro 180º
    if (state.dir.x + dx === 0 && state.dir.y + dy === 0) return;
    state.nextDir = {x:dx,y:dy};
  }

  // Controles teclado
  window.addEventListener('keydown', (e)=>{
    const k = e.key.toLowerCase();
    if (k==='arrowup' || k==='w') setDir(0,-1);
    else if (k==='arrowdown' || k==='s') setDir(0,1);
    else if (k==='arrowleft' || k==='a') setDir(-1,0);
    else if (k==='arrowright' || k==='d') setDir(1,0);
    else if (k===' '){ togglePause(); }
    else if (k==='r'){ reset(); }
  });
  // Controles táctiles / botones
  UI.up.addEventListener('click', ()=>setDir(0,-1));
  UI.down.addEventListener('click', ()=>setDir(0,1));
  UI.left.addEventListener('click', ()=>setDir(-1,0));
  UI.right.addEventListener('click', ()=>setDir(1,0));
  UI.pause.addEventListener('click', togglePause);
  UI.restart.addEventListener('click', reset);
  if (UI.speed){
    UI.speed.addEventListener('change', (e)=>{
      const val = e.target.value;
      if (SPEED_PROFILES[val]){
        selectedProfile = val;
        localStorage.setItem('snakeSpeedProfile', selectedProfile);
        // Reinicia respetando la nueva velocidad
        reset();
      }
    });
  }

  function togglePause(){
    if (state.lost) return;
    state.running = !state.running;
  }

  function step(){
    if (!state.running || state.lost) return;

    // Aplicar dirección planificada
    state.dir = state.nextDir;

    const head = { x: state.snake[0].x + state.dir.x, y: state.snake[0].y + state.dir.y };

    // Colisión con pared
    if (!inBounds(head)){
      return gameOver();
    }

    // Colisión con cuerpo
    if (state.snake.some(seg => eq(seg, head))){
      return gameOver();
    }

    // Mover cabeza
    state.snake.unshift(head);

    // Comer comida
    if (eq(head, state.food)){
      state.score += 10;
      UI.score.textContent = String(state.score);
      state.grow += 1;
  // Acelera ligeramente hasta un mínimo según perfil
  const prof = getProfile();
  state.tick = Math.max(prof.min, state.tick - prof.accel);
      if (state.score > state.best){
        state.best = state.score;
        localStorage.setItem('bestScore', String(state.best));
        UI.best.textContent = String(state.best);
      }
      placeFood();
    }

    // Reducir cola si no hay crecimiento pendiente
    if (state.grow>0) state.grow--; else state.snake.pop();
  }

  function gameOver(){
    state.lost = true;
    state.running = false;
  }

  // Render
  function draw(){
    // Fondo
    CTX.clearRect(0,0,CANVAS.width,CANVAS.height);

    // Food aura
    const fx = state.food.x * CELL + CELL/2;
    const fy = state.food.y * CELL + CELL/2;
    const grad = CTX.createRadialGradient(fx, fy, 2, fx, fy, 18);
    grad.addColorStop(0, 'rgba(245, 158, 11, .35)');
    grad.addColorStop(1, 'rgba(245, 158, 11, 0)');
    CTX.fillStyle = grad;
    CTX.beginPath();
    CTX.arc(fx, fy, 18, 0, Math.PI*2);
    CTX.fill();

    // Food
    CTX.fillStyle = getComputedStyle(document.documentElement).getPropertyValue('--food').trim() || '#f59e0b';
    CTX.fillRect(state.food.x*CELL+3, state.food.y*CELL+3, CELL-6, CELL-6);

    // Snake shadow
    CTX.fillStyle = 'rgba(0,0,0,.25)';
    state.snake.forEach((s,i)=>{
      CTX.fillRect(s.x*CELL+4, s.y*CELL+4, CELL-8, CELL-8);
    });

    // Snake body
    for (let i=state.snake.length-1;i>=0;i--){
      const s = state.snake[i];
      const hue = 140 + (i*2)%30; // leve degradado
      CTX.fillStyle = `hsl(${hue} 65% 45%)`;
      CTX.strokeStyle = 'rgba(255,255,255,.06)';
      CTX.lineWidth = 1;
      roundRect(CTX, s.x*CELL+2, s.y*CELL+2, CELL-4, CELL-4, 6, true, true);
    }

    // Game over banner
    if (state.lost){
      CTX.fillStyle = 'rgba(0,0,0,.55)';
      CTX.fillRect(0,0,CANVAS.width,CANVAS.height);
      CTX.fillStyle = '#e5e7eb';
      CTX.font = 'bold 28px system-ui,Segoe UI,Roboto';
      CTX.textAlign = 'center';
      CTX.fillText('¡Perdiste!', CANVAS.width/2, CANVAS.height/2 - 10);
      CTX.font = '16px system-ui,Segoe UI,Roboto';
      CTX.fillText('Presiona R para reiniciar', CANVAS.width/2, CANVAS.height/2 + 18);
    }

    // Pausa badge
    if (!state.lost && !state.running){
      CTX.fillStyle = 'rgba(0,0,0,.55)';
      CTX.font = 'bold 16px system-ui,Segoe UI,Roboto';
      CTX.textAlign = 'left';
      CTX.fillText('Pausa', 12, 22);
    }
  }

  function roundRect(ctx, x, y, w, h, r, fill, stroke){
    if (w < 2*r) r = w/2; if (h < 2*r) r = h/2;
    ctx.beginPath();
    ctx.moveTo(x+r, y);
    ctx.arcTo(x+w, y, x+w, y+h, r);
    ctx.arcTo(x+w, y+h, x, y+h, r);
    ctx.arcTo(x, y+h, x, y, r);
    ctx.arcTo(x, y, x+w, y, r);
    ctx.closePath();
    if (fill) ctx.fill();
    if (stroke) ctx.stroke();
  }

  // Bucle principal con reloj adaptable
  let last = 0; let acc = 0;
  function loop(ts){
    if (!last) last = ts; // primera llamada
    const dt = ts - last; last = ts;
    acc += dt;
    while (acc >= state.tick){
      step();
      acc -= state.tick;
    }
    draw();
    requestAnimationFrame(loop);
  }

  // Inicio
  placeFood();
  requestAnimationFrame(loop);
})();
