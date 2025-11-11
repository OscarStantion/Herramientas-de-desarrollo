# 🎤 Guión de Presentación - GitHub Actions (CI/CD)

## 📋 Versión 1: Presentación Formal (5-7 minutos)

### 1. Introducción (30 segundos)

**"Buenos días/tardes profesor. Hoy voy a presentar la implementación de Integración Continua (CI/CD) en mi proyecto usando GitHub Actions, aplicando los conceptos de la semana 13."**

---

### 2. ¿Qué es CI/CD? (1 minuto)

**"Primero, permítame explicar brevemente qué es CI/CD:**

- **CI (Continuous Integration)** significa Integración Continua. Es una práctica donde integramos código frecuentemente y verificamos automáticamente que todo funcione.

- **CD (Continuous Delivery/Deployment)** es tener el código siempre listo para producción.

**¿Por qué es importante?**
- Detecta errores temprano, antes de que lleguen a producción
- Automatiza tareas repetitivas como compilar y ejecutar tests
- Mejora la calidad del código
- Facilita el trabajo en equipo

**En mi caso, elegí GitHub Actions porque está integrado nativamente con GitHub, se configura con archivos YAML, y es gratuito para repositorios públicos."**

---

### 3. Demostración de Archivos (1.5 minutos)

**"Déjeme mostrarle los archivos que implementé:"**

#### Abrir VS Code y mostrar:

**"En la carpeta `.github/workflows/` tengo tres workflows:"**

1. **`ci.yml`** (abrir archivo)
   - "Este es el workflow principal que se ejecuta en cada push o pull request"
   - "Mire aquí [señalar]: compila el proyecto con Gradle, ejecuta los tests, y genera artefactos como el JAR"
   - "Todo esto ocurre automáticamente en cada cambio que hago"

2. **`code-quality.yml`** (abrir archivo)
   - "Este workflow analiza la calidad del código y las dependencias"
   - "Es importante para mantener el código limpio y seguro"

3. **`release.yml`** (mostrar rápido)
   - "Este es opcional, crea releases automáticos cuando creo un tag de versión"

**"También creé documentación completa:"**
- "Una guía completa de GitHub Actions"
- "Instrucciones paso a paso"
- "Un resumen de implementación"
- "Y un checklist para verificar todo"

---

### 4. Demostración en GitHub (2 minutos)

**"Ahora déjeme mostrarle cómo funciona en GitHub:"**

#### Ir a GitHub (https://github.com/OscarStantion/Herramientas-de-desarrollo)

**"Aquí está mi repositorio. Voy a la pestaña **Actions**..."**

[Mostrar pestaña Actions]

**"Como puede ver, tengo historial de ejecuciones. Cada vez que hago push, estos workflows se ejecutan automáticamente."**

[Click en una ejecución exitosa]

**"Aquí vemos los detalles: el workflow tardó aproximadamente 3-4 minutos. Podemos ver cada paso que se ejecutó:"**
- Setup de Java 21
- Compilación con Gradle
- Ejecución de tests
- Generación de artefactos

[Mostrar la sección de Artifacts]

**"Y aquí abajo tenemos los artefactos generados: el JAR compilado y los reportes de tests, que puedo descargar en cualquier momento."**

---

### 5. Demostración del Pull Request (1.5 minutos)

**"Ahora déjeme mostrar cómo funciona en un Pull Request..."**

[Ir al PR #1]

**"Este es un Pull Request que tengo abierto. Lo interesante es que GitHub Actions se ejecuta automáticamente en cada PR."**

[Señalar los checks en el PR]

**"Aquí vemos los checks:**
- ✅ El de "Code Quality" pasó exitosamente
- Los tests se ejecutaron automáticamente

**"Esto es muy útil porque antes de hacer merge a main, sé que el código funciona. No puedo hacer merge si los tests fallan. Esto previene errores en la rama principal."**

---

### 6. Demostración del README (30 segundos)

[Ir al README en GitHub]

**"Finalmente, agregué badges de estado en el README:"**

[Señalar los badges en la parte superior]

**"Estos badges muestran el estado actual del proyecto: verde si todo está bien, rojo si algo falla. Es una forma visual de ver la salud del proyecto."**

---

### 7. Beneficios y Conclusión (1 minuto)

**"En resumen, implementé CI/CD con GitHub Actions que me da estos beneficios:**

✅ **Automatización completa:**
   - Compilación automática en cada push
   - Tests automáticos
   - Generación de artefactos

✅ **Calidad de código:**
   - Verificaciones automáticas
   - No se puede hacer merge si algo falla
   - Reportes detallados

✅ **Profesionalismo:**
   - Badges de estado
   - Documentación completa
   - Mismo nivel que proyectos empresariales

**"Esta implementación sigue las mejores prácticas de la industria y demuestra que entiendo los conceptos de integración continua enseñados en clase."**

**"¿Tiene alguna pregunta?"**

---
---

## 📋 Versión 2: Presentación Casual (4-5 minutos)

### 1. Introducción (20 segundos)

**"Hola profe, te voy a mostrar cómo implementé GitHub Actions en mi proyecto. Apliqué lo que vimos en la semana 13 sobre herramientas de integración continua."**

---

### 2. Contexto Rápido (45 segundos)

**"Básicamente, GitHub Actions es una herramienta que automatiza un montón de cosas:**
- Cada vez que subo código, automáticamente compila el proyecto
- Ejecuta todos los tests
- Me avisa si algo se rompió
- Genera el archivo JAR listo para usar

**Es como tener un asistente que revisa tu código 24/7.**

**Elegí GitHub Actions porque ya uso GitHub, es gratis, y se configura fácil con archivos YAML."**

---

### 3. Mostrar los Archivos (1 minuto)

**"Mira, estos son los archivos principales:"**

[Abrir `.github/workflows/ci.yml`]

**"Este archivo dice: 'cada vez que haga push o pull request, haz estas cosas:'"**
- Descarga el código
- Instala Java 21
- Compila todo con Gradle
- Ejecuta los tests
- Sube el JAR generado

**"Todo automático, yo no tengo que hacer nada."**

[Mostrar rápido `code-quality.yml`]

**"Este otro verifica que el código tenga buena calidad y revisa las dependencias."**

---

### 4. Demo en GitHub (1.5 minutos)

**"Ahora te muestro cómo se ve funcionando..."**

[Ir a GitHub Actions]

**"Aquí en la pestaña Actions tengo todas las ejecuciones. Mira esta por ejemplo:"**

[Click en una ejecución]

**"Tardó 3-4 minutos, y puedes ver todos los pasos que hizo: compiló, corrió los tests, todo pasó."**

[Mostrar artifacts]

**"Y aquí abajo están los archivos que generó: el JAR y los reportes. Los puedo descargar cuando quiera."**

---

### 5. Pull Request (1 minuto)

**"Lo mejor es cuando hago un Pull Request..."**

[Ir al PR #1]

**"Mira, aquí automáticamente corrió los checks. No me deja hacer merge si algo falla."**

**"Es súper útil porque sé que si pasa todas las pruebas, mi código está bien y no voy a romper nada en main."**

---

### 6. README (20 segundos)

[Ir al README]

**"Ah, y agregué estos badges que muestran el estado:"**
- Verde = todo bien
- Rojo = algo falló

**"Se ve más profesional y de un vistazo ves cómo está el proyecto."**

---

### 7. Cierre (30 segundos)

**"Entonces, resumiendo:**
- Configuré CI/CD completo
- Se ejecuta automático en cada cambio
- Tengo tests automáticos y artefactos
- Previene errores antes de hacer merge
- Todo documentado

**"¿Alguna duda?"**

---
---

## 🎯 Versión 3: Presentación Ejecutiva (2-3 minutos)

**Para cuando tienes poco tiempo pero quieres causar impacto**

### Apertura (15 segundos)
**"Implementé GitHub Actions para CI/CD en mi proyecto. Les muestro rápido los puntos clave."**

### Demo Directa (1.5 minutos)
[Ir directo a GitHub Actions]

**"Cada push ejecuta automáticamente:"**
1. Compilación ✅
2. Tests ✅
3. Análisis de calidad ✅
4. Generación de artefactos ✅

[Mostrar PR]
**"En Pull Requests, los checks previenen merge de código roto."**

[Mostrar artifacts]
**"Artefactos disponibles: JAR + reportes."**

### Valor Agregado (30 segundos)
**"Beneficios:"**
- Detección temprana de errores
- Automatización completa
- Documentación profesional
- Prácticas de industria

### Cierre (15 segundos)
**"Todo el código y documentación está en `.github/`. ¿Preguntas?"**

---
---

## 💡 Consejos para la Presentación

### Antes de Presentar:

✅ **Practica el guión 2-3 veces**
   - Ajústalo a tu estilo
   - Cronométrate para no pasarte de tiempo
   - Identifica las partes más importantes

✅ **Prepara tu navegador**
   - Pestaña 1: Tu repositorio en GitHub (página principal)
   - Pestaña 2: GitHub Actions (para mostrar ejecuciones)
   - Pestaña 3: Tu Pull Request #1
   - Pestaña 4: VS Code con los archivos abiertos

✅ **Verifica que todo funcione**
   - Los workflows deben estar en verde ✅
   - El Pull Request debe mostrar los checks
   - Los badges en el README deben verse bien

✅ **Ten a mano**
   - Este guión impreso o en otra pantalla
   - Los archivos YAML abiertos en VS Code
   - La documentación por si te preguntan algo

---

### Durante la Presentación:

✅ **Ritmo:**
   - Habla claro y sin prisa
   - Haz pausas para que procesen la información
   - Si te pierdes, respira y retoma

✅ **Interacción:**
   - Mantén contacto visual (si es presencial)
   - Usa "como pueden ver aquí..." mientras señalas
   - Invita preguntas al final

✅ **Manejo de Errores:**
   - Si algo no carga, explica qué debería verse
   - Ten screenshots de respaldo
   - No te pongas nervioso, es normal

✅ **Lenguaje Corporal:**
   - Muéstrate seguro (aunque no lo estés 100%)
   - Sonríe cuando sea apropiado
   - Usa las manos para señalar en pantalla

---

### Posibles Preguntas del Docente:

**P: "¿Por qué elegiste GitHub Actions y no Jenkins u otra herramienta?"**

**R:** "Elegí GitHub Actions porque:
- Ya estoy usando GitHub para el proyecto
- Es nativo, no necesito configurar servidores externos
- Es gratuito para repositorios públicos
- Se configura fácil con YAML
- Tiene integración perfecta con Pull Requests"

---

**P: "¿Qué pasa si un test falla?"**

**R:** "Si un test falla:
- El workflow marca todo en rojo ❌
- No puedo hacer merge del Pull Request
- Puedo ver los logs exactos del error
- Corrijo el error localmente
- Hago push y automáticamente se vuelve a ejecutar
- Esto previene código roto en main"

---

**P: "¿Cuánto tarda en ejecutarse?"**

**R:** "Aproximadamente 3-5 minutos por ejecución. La primera vez puede tardar más, pero después usa caché para las dependencias y es más rápido."

---

**P: "¿Qué otros servicios evaluaste?"**

**R:** "Consideré:
- **Jenkins**: Muy potente pero requiere servidor propio
- **GitLab CI**: Bueno pero tendría que migrar todo a GitLab
- **CircleCI**: Buena opción pero GitHub Actions está mejor integrado
- **Travis CI**: Ya no es tan popular

GitHub Actions ganó por conveniencia, costo cero, y integración perfecta."

---

**P: "¿Esto funciona en equipo?"**

**R:** "Sí, de hecho es donde más brilla:
- Cada miembro del equipo puede ver el estado de los builds
- Los PRs muestran automáticamente si el código pasa las pruebas
- Evita que alguien rompa main accidentalmente
- Todos pueden descargar los artefactos generados
- Es transparente: todos ven los mismos resultados"

---

**P: "¿Qué harías diferente o mejorarías?"**

**R:** "Para el futuro me gustaría agregar:
- **Code coverage** con JaCoCo para medir cobertura de tests
- **Análisis de seguridad** con Snyk para detectar vulnerabilidades
- **Deploy automático** a un servidor de staging
- **Notificaciones** en Discord cuando algo falla
- **Tests de integración** además de los unitarios"

---

**P: "¿Tuviste algún problema durante la implementación?"**

**R:** "Sí, tuve un problema con los permisos del archivo `gradlew`. En Linux/Ubuntu (que es lo que usa GitHub Actions), los archivos necesitan permisos de ejecución explícitos. Lo resolví con:
```bash
git update-index --chmod=+x gradlew
```
Después de eso todo funcionó perfecto."

---

## 🎬 Estructura de Tiempo Sugerida

### Para 5 minutos:
- 0:00 - 0:30 → Introducción y contexto
- 0:30 - 2:00 → Mostrar archivos y explicar workflows
- 2:00 - 3:30 → Demo en GitHub (Actions + PR)
- 3:30 - 4:30 → Beneficios y conclusión
- 4:30 - 5:00 → Preguntas

### Para 3 minutos:
- 0:00 - 0:15 → Introducción breve
- 0:15 - 1:30 → Demo directo en GitHub Actions
- 1:30 - 2:30 → Mostrar PR y explicar valor
- 2:30 - 3:00 → Cierre y preguntas

---

## 📝 Notas Finales

### Personalización:
- **Lee el guión varias veces** y cámbialo a tu vocabulario natural
- **No memorices palabra por palabra**, usa el guión como guía
- **Agrega ejemplos personales** si los tienes
- **Ajusta el nivel técnico** según tu docente

### Actitud:
- **Muestra entusiasmo** por lo que hiciste
- **Sé honesto** si no sabes algo
- **Pide feedback** al final
- **Agradece** el tiempo del docente

---

## ✨ Frase de Cierre Potente

Elige una para terminar con impacto:

**Opción 1 (Profesional):**
*"Con esta implementación, mi proyecto ahora sigue las mismas prácticas de CI/CD que usan empresas como Google, Microsoft y Facebook. Gracias por su tiempo."*

**Opción 2 (Casual):**
*"Básicamente convertí mi proyecto de estudiante en algo que se ve y funciona profesional. Espero que cumpla con lo requerido para la semana 13."*

**Opción 3 (Técnica):**
*"Implementé un pipeline completo de CI/CD con compilación automática, tests, análisis de calidad y generación de artefactos. Todo siguiendo las mejores prácticas de DevOps moderno."*

---

## 🎯 Checklist Pre-Presentación

- [ ] Leí el guión completo 3 veces
- [ ] Adapté el guión a mi estilo de hablar
- [ ] Practiqué frente al espejo o con amigos
- [ ] Verifiqué que los workflows estén en verde ✅
- [ ] Preparé las pestañas del navegador
- [ ] Tengo VS Code abierto con los archivos
- [ ] Sé responder las posibles preguntas
- [ ] Cronometré mi presentación
- [ ] Estoy listo para impresionar 🚀

---

**¡MUCHA SUERTE! 🍀**

Recuerda: Ya hiciste el trabajo difícil (implementar todo). La presentación es solo mostrar lo que hiciste. **Confía en ti mismo.**
