import java.util.Scanner;
public class Main{
    //Objeto Scanner (scanner) y objeto Gestion (gestion)
    private static Scanner scanner = new Scanner(System.in);
    private static Gestion gestion = new Gestion();
    //Variable de gra uso.Mansaje de saludo.
    private static final String Mensaje_Saliendo = "Saliendo... \nVolviendo a menú: ";
    //Main
    public static void main(String[]args){
        Menu();
        System.out.println("Gracias por usar nuestro programa.\nEjecucion terminada.");
    }
    //Metodo para el menú principal (Menu)
    public static void Menu(){
        System.out.println("______Menú_Principal_____");
        
        System.out.println("1- Socio \n2- Actividad \n3- Participa \n0- Salir");
        int opcionPrincipal = scanner.nextInt();
        
        while(opcionPrincipal != 0){
            
            switch(opcionPrincipal){
                
                case 1: menuSocios(); break;
                
                case 2: menuActividades(); break;
                
                case 3: menuParticipaciones(); break;
                
                default: System.out.println("Opción no valida."); break;
                
            }
            System.out.println("______Menú_Principal_____");
            System.out.println("1- Socios \n2- Actividades \n3- Participa \n0- Salir");
            opcionPrincipal = scanner.nextInt();
        }
        
    }
    //Metodo para el menú de los socios (menuSocios)
    public static  void menuSocios(){
       System.out.println("______Menú_Socios_____");
                System.out.println("1- Agregar \n2- Eliminar \n3- Modificar \n4- Vre \n0- Salir");
                int opcionSocios = scanner.nextInt();
                while(opcionSocios != 0){
                    switch(opcionSocios){
                        
                        case 1: gestion.AgregarSocio(); break;
                        
                        case 2: gestion.EliminarSocio(); break;
                        
                        case 3: gestion.ModificarSocio(); break;
                        
                        case 4: gestion.VerSocios(); break;
                        
                        default : System.out.println("Opción no valida."); break;
                    }
                    System.out.println("______Menú_Socios_____");
                    System.out.println("1- Agregar \n2- Eliminar \n3- Modificar \n4- Vre \n0- Salir");
                    opcionSocios = scanner.nextInt();
                }
                System.out.println(Mensaje_Saliendo+"Principal");
    }
    //Metodo para el menú de las actividades (menuActividades)
    public static void menuActividades(){
        System.out.println("______Menú_Actividades_____");
                System.out.println("1- Agregar \n2- Eliminar \n3- Modificar \n4- Vre \n0- Salir");
                int opcionActividades = scanner.nextInt();
                while(opcionActividades != 0){
                    switch(opcionActividades){
                        
                        case 1: gestion.AgregarActividad(); break;  
                        
                        case 2: gestion.EliminarActividad(); break;
                        
                        case 3: gestion.ModificarActividad(); break;
                        
                        case 4: gestion.VerActividades(); break;
                        
                        default : System.out.println("Opción no valida."); break;
                    }
                    System.out.println("______Menú_Actividades_____");
                    System.out.println("1- Agregar \n2- Eliminar \n3- Modificar \n4- Vre \n0- Salir");
                    opcionActividades = scanner.nextInt();
                }
                System.out.println(Mensaje_Saliendo+"Principal");
    }
    //Metodo para el menú de las participaciones (menuParticipaciones)
    public static void menuParticipaciones(){
        System.out.println("______Menú_Participa_____");
        System.out.println("1- Agregar \n2- Eliminar \n3- Vre \n0- Salir");
        int opcionParticipa = scanner.nextInt();
                while(opcionParticipa != 0){
                    switch(opcionParticipa){
                        
                        case 1: gestion.AgregarParticipacion(); break;  
                        
                        case 2: gestion.EliminarParticipacion(); break;
                        
                        case 3: gestion.VerParticipaciones(); break;
                        
                        default : System.out.println("Opción no valida."); break;
                    }
                    System.out.println("______Menú_Participa__________");
                    System.out.println("1- Agregar \n2- Eliminar \n3- Vre \n0- Salir");
                    opcionParticipa = scanner.nextInt();
                }
                System.out.println(Mensaje_Saliendo+"Principal");
    }
    
}
//Los "while" que se usan son para poder "navegar" entre bucles y poder repetir o hacer barias acciones.
//Usamos "switch" para entrar en la opcion que el usuario elija.