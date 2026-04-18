package Amado;

import java.util.Scanner;
public final class Principal {
	
	
		  static final int biblioteca  = 20;
		  static String[] libros = new String[biblioteca];
		  static int cont = 0;
		  static String librosIngresados; 
		  static Scanner sc = new Scanner(System.in);
		 
		  static void agregarLibro() {
		        if (cont < biblioteca) {
		        	Scanner sc= new Scanner (System.in);
		            System.out.print("Ingrese el título del libro: ");
		            librosIngresados=sc.nextLine();
		            libros[cont] = librosIngresados;
		           
		            cont++;
		            System.out.println("Libro agregado exitosamente");
		        } else {
		            System.out.println("No se pueden agregar más libros");
		        }
		    }
		  public static void modificarLibro() {
			  Scanner sc = new Scanner(System.in);
			  System.out.print("Introduce el número del libro que deseas modificar (1 a " + cont + "): ");
			  int indice = sc.nextInt() - 1;
			  sc.nextLine();
			  if (indice >= 0 && indice < cont) {
			  System.out.print("Introduce el nuevo título del libro: ");
			  libros[indice] = sc.next();
			  System.out.println("Libro modificado con éxito.");
			  } else {
			  System.out.println("Índice inválido.");
			  }
			  }
		  static void eliminarLibros() {
			  int pos=0;
			  Scanner sc = new Scanner(System.in);
			 
			  System.out.println("Introduce el título del libro a eliminar: ");
		        String tituloBuscado = sc.next();       
		        boolean encontrado = false;
		        for (int i = 0; i < cont; i++) {
		            if (libros[i].equalsIgnoreCase(librosIngresados)) {
		                System.out.println("Libro eliminado: " + libros[cont - 1 ]);
		                encontrado = true;
		                break;
		           
		            }else {
			            System.out.println("El libro no fue encontrado.");
		         
		             }
		        }
		  }
		  static void listaLibros() {
	        System.out.println("la lista de libros es: ");
	        for (int i = 0; i < cont; i++) {
	            System.out.println(i + ": "+ libros[i]);
	          
	        }
	    }
		
		  public static void buscarLibro() {
		        Scanner sc = new Scanner(System.in);
		        System.out.println("Introduce el título del libro a buscar: ");
		        String tituloBuscado = sc.next();       
		        boolean encontrado = false;
		        for (int i = 0; i < cont; i++) {
		            if (libros[i].equalsIgnoreCase(tituloBuscado)) {
		                System.out.println("Libro encontrado: " + libros[i]);
		                encontrado = true;
		                break;
		            }
		        }
		        if (!encontrado) {
		            System.out.println("El libro no fue encontrado.");
		        }
		    }
	 public static void main(String[] args) {
	   
	     int opc=30;
	  
	      do {
	     System.out.println("---------Menu-----------");
	     System.out.println("1--Agregar su libro-----");
	     System.out.println("2----Modificar libro----");
	     System.out.println("3----Eliminar libro-----");
	     System.out.println("4-Lista stock de libros-");
	     System.out.println("5-----Buscar libro------");
	     System.out.println("6--------Salir----------");
	     System.out.println("Ingrese la opcion de tu preferencia: ");
	     opc = sc.nextInt();
	  
	     switch (opc) {
	     case 1:
	  	
	  	   agregarLibro();
	       
		 
	          break;
	     case 2:
	   	  modificarLibro();
	     
	     
	         break;
	     case 3:
	   	  eliminarLibros();
	    
	      
	         break;
	     case 4:
	  	   listaLibros();
	  	
	     
	     
	         break;
	     case 5:
	   	  buscarLibro();
	      
	      
	         break;
	     case 6:
	         System.out.println("usted a decidido salir del menu");
	         break;
	     default:
	           System.out.println("opcion no valida");
	             break;
	     }
	   }while(opc!=6);
	 }
	}





