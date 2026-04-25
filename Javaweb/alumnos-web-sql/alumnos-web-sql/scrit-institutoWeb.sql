
-- 1. Crear la base de datos
CREATE DATABASE IF NOT EXISTS institutoWeb2
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- 2. Usar la base de datos
USE institutoWeb2;

-- 3. Crear la tabla persona
CREATE TABLE persona (
    codigo INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL
)

-- 4. Insertar algunos datos de ejemplo (opcional)
INSERT INTO persona (codigo, nombre) VALUES
(1, 'Juan'),
(2, 'María'),
(3, 'Carlos'),
(4, 'Ana'),
(5, 'Pedro');

-- 5. Verificar la creación
SELECT * FROM persona;
