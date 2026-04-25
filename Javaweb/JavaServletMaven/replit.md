# Descripción General

Esta es una mini aplicación web CRUD construida con **Java Servlets** para gestionar registros de personas.  
La aplicación ofrece una interfaz web sencilla en español para **agregar** y **listar** personas, con un diseño limpio y fácil de usar gracias al estilo en CSS.  
Sigue la estructura tradicional de una aplicación web Java con **frontend en HTML** y **backend basado en servlets**.

---

# Preferencias del Usuario
- Estilo de comunicación preferido: **Lenguaje simple y cotidiano**

---

# Arquitectura del Sistema

## Arquitectura Frontend
- **Páginas HTML estáticas**: estructura simple basada en formularios.
- **Diseño con CSS Grid**: sistema moderno y adaptable con diseño en 2 columnas (etiquetas y controles).
- **Navegación por acciones**: enrutamiento mediante parámetros en la URL (`?action=agregar`, `?action=listar`).
- **Estilo de componentes**: CSS centralizado con clases reutilizables para botones y contenedores de formularios.

## Arquitectura Backend
- **Framework Java Servlet**: aplicación web tradicional con patrón **MVC**.
- **Controlador basado en acciones**: un único servlet (`/persona`) que maneja múltiples operaciones según parámetros en la URL.
- **Estructura de proyecto Maven**: directorio estándar con `src/main/webapp` para recursos web.
- **Salida compilada**: el directorio `target` contiene los artefactos listos para desplegar.

---

# Gestión de Datos
- **Operaciones CRUD**: implementadas `Crear` y `Leer` (agregar/listar).
- **Entidad Persona**: modelo de datos central enfocado en registros de personas.
- **Procesamiento por acción**: cada operación depende del parámetro `action`.

---

# Diseño UI/UX
- **Diseño adaptable**: layout centrado con ancho máximo de 640px.
- **Interfaz centrada en formularios**: disposición con grid, espaciado y alineación adecuados.
- **Accesibilidad**: botones deshabilitados muestran retroalimentación visual.
- **Estilo limpio**: diseño en tarjetas con sombras y bordes redondeados.

---

# Dependencias Externas

## Herramientas de construcción
- **Maven**: gestión de dependencias y construcción del proyecto.

## Tecnologías Web
- **Java Servlet API**: framework central de la aplicación.
- **HTML5**: estructura de marcado en el frontend.
- **CSS3**: estilos modernos con grid layout y flexbox.

---

# Entorno de Despliegue
- **Contenedor web Java**: requiere un contenedor de servlets (Tomcat, Jetty, etc.).
- **Servidor web**: entrega de recursos estáticos vía HTTP.

---

> **Nota**: La aplicación se encuentra en fase de desarrollo con funcionalidades CRUD básicas.  
En futuras versiones se podrán integrar bases de datos y más operaciones sobre entidades.