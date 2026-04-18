package vista;

import controlador.PersonaControlador;
import modelo.vo.PersonaVO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonaControlador controlador = new PersonaControlador();
        int opcion;
        do {
            System.out.println("1. Agregar\n"
                    + "2. Actualizar\n"
                    + "3. Eliminar\n"
                    + "4. Buscar\n"
                    + "5. Listar\n"
                    + "0. Salir");
            System.out.println("\nIngrese una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 : {
                    PersonaVO p=new PersonaVO();
                    p.pedirDatos();
                    controlador.agregar(p);         
                    
                    break;
                }
                case 2 : {
                    System.out.print("Cédula a actualizar: "); int c = sc.nextInt();
                    System.out.print("Nuevo nombre: "); String n = sc.next();
                    System.out.print("Nuevo apellido: "); String a = sc.next();
                    System.out.println(controlador.modificar(new PersonaVO(c, n, a)));
                    break;
                }
                case 3: {
                    System.out.print("Cédula a eliminar: "); 
                    int c = sc.nextInt();
                    System.out.println(controlador.borrar(c));
                    break;
                }
                case 4:{
                    System.out.print("Cédula a buscar: "); 
                    int c = sc.nextInt();
                    PersonaVO p = controlador.buscar(c);
                    if (p!= null)
                        System.out.println(p.toString());
                    else
                        System.out.println("Persona no encontrada");
                    break;
                }
                case 5: controlador.obtenerTodas().forEach(System.out::println);
                break;
            }
        } while (opcion != 0);
    }
}
