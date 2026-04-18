package paquete;

import java.util.Scanner;

public class CuestionarioBasico{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int puntaje = 0;

        System.out.println("¡Bienvenido al cuestionario de cultura general!");

        // Preguntas
        String[] preguntas = {
            "1. ¿Cuál es el océano más grande del mundo?\n a) Océano Atlántico\n b) Océano Pacífico\n c) Océano Índico\n d) Océano Ártico",
            "2. ¿Quién pintó la Mona Lisa?\n a) Vincent van Gogh\n b) Leonardo da Vinci\n c) Pablo Picasso\n d) Michelangelo",
            "3. ¿Cuál es la capital de Francia?\n a) Berlín\n b) Londres\n c) París\n d) Madrid",
            "4. ¿Cuál es el río más largo del mundo?\n a) Río Nilo\n b) Río Amazonas\n c) Río Yangtsé\n d) Río Misisipi",
            "5. ¿Quién escribió 'Don Quijote de la Mancha'?\n a) William Shakespeare\n b) Miguel de Cervantes\n c) Gabriel García Márquez\n d) Jorge Luis Borges",
            "6. ¿Cuál es el metal más caro del mundo?\n a) Oro\n b) Platino\n c) Rodio\n d) Rutenio",
            "7. ¿Quién fue el primer presidente de los Estados Unidos?\n a) Abraham Lincoln\n b) George Washington\n c) Thomas Jefferson\n d) John Adams",
            "8. ¿Cuál es el planeta más grande del sistema solar?\n a) Marte\n b) Júpiter\n c) Saturno\n d) Neptuno",
            "9. ¿Quién escribió 'Romeo y Julieta'?\n a) Christopher Marlowe\n b) William Shakespeare\n c) Jane Austen\n d) Charles Dickens",
            "10. ¿Cuál es el elemento químico más abundante en la corteza terrestre?\n a) Hierro\n b) Oxígeno\n c) Silicio\n d) Aluminio"
        };

        // Respuestas correctas
        String[] respuestasCorrectas = {"b", "b", "c", "b", "b", "c", "b", "b", "b", "c"};

        // Proceso de preguntas y respuestas
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println(preguntas[i]);
            System.out.print("Ingrese su respuesta (a, b, c, d): ");
            String respuesta = teclado.nextLine().toLowerCase();
            if (respuesta.equals(respuestasCorrectas[i])) {
                System.out.println("¡Respuesta correcta!");
                puntaje++;
            } else {
                System.out.println("Respuesta incorrecta. La respuesta correcta es: " + respuestasCorrectas[i]);
            }
            System.out.println();
        }

        // Mostrar puntaje final
        System.out.println("¡Cuestionario completado!");
        System.out.println("Puntaje final: " + puntaje + " de " + preguntas.length);
    }
}




