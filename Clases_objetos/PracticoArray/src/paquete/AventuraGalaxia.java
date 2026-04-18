package paquete;
import java.util.Scanner;

public class AventuraGalaxia {
	


	    // Misión 1: Creación de Arrays
	    public static void mostrarObjetos(String[] objetos) {
	        System.out.println("Objetos recolectados:");
	        for (String objeto : objetos) {
	            System.out.println(objeto);
	        }
	    }

	    public static String[] agregarObjeto(String[] objetos, String nuevoObjeto) {
	        String[] nuevosObjetos = new String[objetos.length + 1];
	        for (int i = 0; i < objetos.length; i++) {
	            nuevosObjetos[i] = objetos[i];
	        }
	        nuevosObjetos[objetos.length] = nuevoObjeto;
	        return nuevosObjetos;
	    }

	    // Misión 2: Acceso a elementos en el array
	    public static void accederElementos(String[] objetos) {
	        if (objetos.length > 0) {
	            System.out.println("Primer objeto: " + objetos[0]);
	            System.out.println("Último objeto: " + objetos[objetos.length - 1]);
	        }
	    }

	    public static void mostrarPenultimo(String[] objetos) {
	        if (objetos.length >= 2) {
	            System.out.println("Penúltimo objeto: " + objetos[objetos.length - 2]);
	        }
	    }

	    // Misión 3: Modificación de elementos en el array
	    public static void reemplazarElemento(String[] objetos, int indice, String nuevoObjeto) {
	        if (indice >= 0 && indice < objetos.length) {
	            objetos[indice] = nuevoObjeto;
	        }
	    }

	    // Misión 4: Añadir y eliminar elementos en el array
	    public static String[] insertarElemento(String[] objetos, String nuevoObjeto, int indice) {
	        String[] nuevosObjetos = new String[objetos.length + 1];
	        for (int i = 0; i < indice; i++) {
	            nuevosObjetos[i] = objetos[i];
	        }
	        nuevosObjetos[indice] = nuevoObjeto;
	        for (int i = indice; i < objetos.length; i++) {
	            nuevosObjetos[i + 1] = objetos[i];
	        }
	        return nuevosObjetos;
	    }

	    public static String[] eliminarObjeto(String[] objetos, String objetoEliminar) {
	        int count = 0;
	        for (String objeto : objetos) {
	            if (objeto.equals(objetoEliminar)) {
	                count++;
	            }
	        }
	        if (count == 0) {
	            System.out.println("El objeto no se encuentra en el array.");
	            return objetos;
	        }
	        String[] nuevosObjetos = new String[objetos.length - count];
	        int j = 0;
	        for (String objeto : objetos) {
	            if (!objeto.equals(objetoEliminar)) {
	                nuevosObjetos[j] = objeto;
	                j++;
	            }
	        }
	        return nuevosObjetos;
	    }

	    // Misión 5: Operaciones con Arrays
	    public static String[] combinarArrays(String[] objetos, String[] herramientas) {
	        String[] inventario = new String[objetos.length + herramientas.length];
	        for (int i = 0; i < objetos.length; i++) {
	            inventario[i] = objetos[i];
	        }
	        for (int i = 0; i < herramientas.length; i++) {
	            inventario[objetos.length + i] = herramientas[i];
	        }
	        return inventario;
	    }

	    public static void contarElementos(String[] inventario) {
	        System.out.println("Cantidad de elementos en el inventario: " + inventario.length);
	    }

	    public static void buscarObjeto(String[] inventario, String objetoBuscar) {
	        boolean encontrado = false;
	        for (String objeto : inventario) {
	            if (objeto.equals(objetoBuscar)) {
	                encontrado = true;
	                break;
	            }
	        }
	        if (encontrado) {
	            System.out.println(objetoBuscar + " está en el inventario.");
	        } else {
	            System.out.println(objetoBuscar + " no se encuentra en el inventario.");
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Misión 1
	        String[] objetos = {"Sable de luz", "Holocrón", "Mapa estelar"};
	        mostrarObjetos(objetos);

	        System.out.print("Ingresa un nuevo objeto: ");
	        String nuevoObjeto = sc.nextLine();
	        objetos = agregarObjeto(objetos, nuevoObjeto);
	        mostrarObjetos(objetos);

	        // Misión 2
	        accederElementos(objetos);
	        mostrarPenultimo(objetos);

	        // Misión 3
	        System.out.print("Ingresa un nuevo objeto para reemplazar el segundo: ");
	        String objetoReemplazo = sc.nextLine();
	        reemplazarElemento(objetos, 1, objetoReemplazo);
	        mostrarObjetos(objetos);

	        // Misión 4
	        System.out.print("Ingresa un objeto para insertar en la segunda posición: ");
	        String objetoInsertar = sc.nextLine();
	        objetos = insertarElemento(objetos, objetoInsertar, 1);
	        mostrarObjetos(objetos);

	        System.out.print("Ingresa un objeto para eliminar: ");
	        String objetoEliminar = sc.nextLine();
	        objetos = eliminarObjeto(objetos, objetoEliminar);
	        mostrarObjetos(objetos);

	        // Misión 5
	        String[] herramientas = {"Desarmador", "Llave inglesa", "Martillo"};
	        String[] inventario = combinarArrays(objetos, herramientas);
	        mostrarObjetos(inventario);
	        contarElementos(inventario);

	        System.out.print("Ingresa un objeto para buscar en el inventario: ");
	        String objetoBuscar = sc.nextLine();
	        buscarObjeto(inventario, objetoBuscar);
	    }
	}
	