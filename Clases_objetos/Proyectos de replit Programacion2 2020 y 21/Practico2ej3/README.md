 Crear la clase Persona con  los atributos **apellido**, **edad,**  **altura, cedula** (long int), **sexo** (char con valor 'm' o 'f') y **peso** (double).

Deberá incluir también: **Constructor específico**, **getters**, **setters** y **toString**. 

Métodos específicos

• **public boolean esMayor()**: Devuelve true si es mayor de edad o false para el caso

contrario.

• **public void generaCI()**: Genera un valor aleatorio para cédula, entre 6.000.000 y

7.000.000.

• **public int calcularIMC():** Calcula si la persona esta en su peso ideal: (peso / altura2).

Si esta en forma el resultado es menor a 20, y el método devuelve -1. Si es un número

entre 20 y 25, significa que esta por debajo de su peso ideal, el método devuelve un 0. Si

es mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. **(EJERCICIO OPCIONAL)**

En la **clase Principal** deberá generar tres objetos de la clase Persona.  Crear  un objeto con valores por defecto 2  objetos con el constructor específico con valores ingresados por teclado (menos la cédula que se genera aleatoria). 

Para ingresar valores por teclado, puede crear el método **cargarDatos()**

Luego se pide:

• Utilizar el método toString para cada objeto  para visualizar los objetos.

• Utilizar los métodos  esMayor (y calcularIMC si lo hizo), deberá imprimir los resultados por pantalla.

