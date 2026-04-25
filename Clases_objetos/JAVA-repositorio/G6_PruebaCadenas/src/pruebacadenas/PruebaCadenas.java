/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejemplo 2: Métodos disponibles para manipular cadenas de caracteres.
 */
package pruebacadenas;

/**
 * @date 12/06/2018
 * @author Fredy Kcrez
 */
public class PruebaCadenas {

    public static void main(String[] args) {
        int i;
        String str= "Hola";
        
        //Concatena una cadena
        str = str.concat(" Mundo");
        System.out.println(str);
        i= str.length();
        System.out.println("La longitud de " + str + " es: " + i);
        
        //Uso de la función charAt
        for(i=0; i<10; i++) {
            System.out.println(str.charAt(i));
        }
        //¿Qué pasa con las siguiente instrucción?
        //System.out.println(str.charAt(10));
        
        //Ejemplo de uso de replace
        str = "Hola mundo";
        System.out.println(str.substring(2));
        System.out.println(str.substring(5));
        System.out.println(str.substring(6));
        
        //Texto en minusculas o marusculas
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
    }
    
}
