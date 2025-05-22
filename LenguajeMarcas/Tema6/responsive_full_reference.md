1. Añade en `<head>`:
```html
<meta name="viewport" content="width=device-width, initial-scale=1">
```

2. Usa unidades fluidas (`%, vw, vh, rem`) en lugar de px:
```css
width: 100%;
padding: 1rem;
```

3. Define puntos de quiebre clave:
```css
/* móvil: hasta 600px */
@media (max-width: 600px) { … }
/* tablet: hasta 900px */
@media (max-width: 900px) { … }
```

4. Reemplaza columnas fijas por Flex/Grid fluidos:
```css
.container { display: flex; flex-wrap: wrap; }
.item { flex: 1 1 300px; }
```

5. Convierte menús horizontales en “hamburguesa”:
- Oculta nav en móvil: `display: none;`
- Muestra botón que al clic añade/clase `.open` para mostrarlo `display: block;`

6. Practica con estos ejercicios:
- A: convierte un diseño de 3 columnas en una sola columna en móvil.  
- B: ajusta imágenes al 100% del contenedor.  
- C: crea una barra fija en la parte superior que se reduzca en móvil.  
- D: diseña un formulario de 2 columnas que pase a 1 columna bajo 600px.

7. Plantilla rápida:
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body { margin:0; font-family:sans-serif; }
    .container{ display:grid; grid-template-columns: repeat(auto-fit,minmax(250px,1fr)); gap:1rem; }
    @media (max-width:600px){ .sidebar, .aside{ display:none } }
  </style>
</head>
<body>
  <header>…</header>
  <div class="container">
    <nav class="sidebar">…</nav>
    <main>…</main>
    <aside class="aside">…</aside>
  </div>
  <footer>…</footer>
</body>
</html>
```

8. Revisa en navegador (Modo Responsive) tras cada cambio.
