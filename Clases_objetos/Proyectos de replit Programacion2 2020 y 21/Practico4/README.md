Sea la clase **Articulo** desarrollada en el **Practico 3 realizar las siguientes clases:**

 

> Ejercicio 2 (Desarrollo de Nacional):

• **public double precioVenta()**: Los artículos Nacionales con subsidiado mantienen el

precioVenta original (super.precioVenta()), en tanto que los no subsidiados suman un

15% extra si el departamento es Montevideo y un 10% si son del interior.

**• public String toString():** Imprime la información de los atributos de la clase (y los que

hereda), además del valor de precio de venta.

> Ejercicio 3 (Desarrollo de Importado):

• **public double precioVenta()**: Los artículos Importados suman al precioVenta original

un 80% de su impuesto si su anioImportacion es menor o igual a 2008. Caso contrario se

agrega un 100% del valor del impuesto.

• public String toString(): Imprime la información de los atributos de la clase (y los que

hereda), además del valor de precio de venta.

> Ejercicio 4 (La clase Principal):

• Crear el objeto n de tipo Nacional con el constructor por defecto. Cargar sus valores con

los setters correspondientes. Visualizar el objeto con toString.

• Crear el objeto i de tipo Importado con el constructor específico. Visualizar el objeto con

toString.

