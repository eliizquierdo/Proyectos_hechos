import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
public class Gestion {

    //ArrayList y el scanner.
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Socio> listaSocios;
	private ArrayList<Actividad> listaActividades;
	private ArrayList<Participa> listaParticipaciones;
	
	//Variables de gran uso.
	//Mensajes de ingresos
	private final String Mensaje_Ingrese_Cedula = "Ingrese la cédula del socio: ";
	private final String Mensaje_Ingrese_Nombre = "Ingrese el nombre del la actividad: ";
	//Mensajes de errores
	private final String Mensaje_No_Socios = "No hay socios registrados.";
    private final String Mensaje_No_Actividades = "No hay actividades registradas.";
    private final String Mensaje_No_Participaciones = "No hay participaciones registradas.";
    private final String Mensaje_Opcion_Invlida = "Opción no válida. Por favor, ingrese un valor válido.";
    //Mensaje de salida
    private final String Mensaje_Saliendo = "Saliendo... \nVolviendo a menú: ";

    //Constructor
	public Gestion() {
		listaSocios = new ArrayList<>();
		listaActividades = new ArrayList<>();
		listaParticipaciones = new ArrayList<>();
	}

    //Hace que el usuario ingrese la cantidad de dijitos correctos en valores numericos.
    public boolean validar(int valor, int index) {
        String Str = String.valueOf(valor);
        return Str.length() == index;
    }
//Metodos de actividad
    //Berifica si la cedula ingresada esta o no agregado en el sistema.
	public boolean verificarSocio(int cedula) {
		boolean tfSocio = false;
		if(!listaSocios.isEmpty()) {
			for (int i = 0; i < listaSocios.size(); i ++) {
				Socio socioBuscado = listaSocios.get(i);
				if(socioBuscado.getCedula() == cedula) {
					tfSocio = true;
				}
			}
		}
		return tfSocio;
	}

    //Permite ingresar socios al sistema.
	public void AgregarSocio() {
		System.out.println("_______Agregar_Socio________");
		Socio socio = new Socio();

		System.out.println(Mensaje_Ingrese_Cedula);
		int cedula = scanner.nextInt(); scanner.nextLine();
		boolean index = validar(cedula, 8);
		while(index != true){
		    System.out.println("La cedula ingresada tiene más o menos dijitos. Asegurese de que la cedula tenga 8 dijitos.");
		    System.out.println(Mensaje_Ingrese_Cedula);
		    cedula = scanner.nextInt(); scanner.nextLine();
		    index = validar(cedula, 8);
		}
		socio.setCedula(cedula);

		if (!verificarSocio(cedula)) {
			System.out.println("Ingrese el nombre: ");
			String nombre = scanner.nextLine();
			socio.setNombre(nombre);

			System.out.println("Ingrese el apellido: ");
			String apellido = scanner.nextLine();
			socio.setApellido(apellido);

			System.out.println("Ingrese la fecha de nacimiento (AAAA-MM-DD): ");
			String fechaStr = scanner.nextLine();
			LocalDate fechaNacimiento = LocalDate.parse(fechaStr);
			socio.setFechaNacimiento(fechaNacimiento);

			System.out.println("Ingrese la direccion: ");
			Direccion direccion = new Direccion();
			direccion.ingresarDireccion();
			socio.setDireccion(direccion);

			System.out.println("Ingrese el telefono: ");
			int telefono = scanner.nextInt(); scanner.nextLine();
			index = validar(telefono, 8);
		    while(index != true){
		        System.out.println("El teléfono ingresado tiene más o menos dijitos. Asegurese de que el teléfono tenga 8 dijitos.");
		        System.out.println("Ingrese la cedula: ");
		        telefono = scanner.nextInt();
		        scanner.nextLine();
		        index = validar(telefono, 8);
		    }
			socio.agregarTelefono(telefono);
			int opcion = 0;
			do{
			    System.out.println("¿Quieres agregar un nuevo número telefonico? \n1- Si \n0- No)");
			    opcion = scanner.nextInt(); scanner.nextLine();
			    switch(opcion){
			        case 1:System.out.println("Agrega un nuevo numero teléfonico: ");
			            telefono = scanner.nextInt(); scanner.nextLine();
			            index = validar(telefono, 8);
		                while(index != true){
		                    System.out.println("El teléfono ingresado tiene más o menos dijitos. Asegurese de que el teléfono tenga 8 dijitos.");
		                    System.out.println("Ingrese la cedula: ");
		                    telefono = scanner.nextInt(); scanner.nextLine();
		                    index = validar(telefono, 8);
		                }
			            socio.agregarTelefono(telefono);
			            break;
			           case 0: break;
			        default: System.out.println(Mensaje_Opcion_Invlida);
			        break;
			    }
			}while(opcion != 0);

			System.out.println("Ingrese el email: ");
			String email = scanner.nextLine();
			socio.setEmail(email);

			System.out.println("Ingrese la mensualidad: ");
			double mensualidad = scanner.nextDouble(); scanner.nextLine();
			socio.setMensualidad(mensualidad);

			listaSocios.add(socio);
			System.out.println("Socio con cedula " + cedula + " agregado exitosamente.");
		}else {System.out.println("El socio " + cedula + " ya esta en el sistema.");}
		System.out.println(Mensaje_Saliendo + "Socio");
	}

    //Permite eliminar socios del sistema.
	public void EliminarSocio() {
	    if(listaSocios.isEmpty()){System.out.println( Mensaje_No_Socios );}
	    else{
	        System.out.println("_______Eliminar_Socio________");

		    System.out.println(Mensaje_Ingrese_Cedula);
		    int cedula = scanner.nextInt(); scanner.nextLine();
		    if (verificarSocio(cedula)) {
                for(int i = 0; i < listaSocios.size(); i++){
                    Socio socio = listaSocios.get(i);
                    if(socio.getCedula()==cedula){
                        listaSocios.remove(i);
                        System.out.println("Socio " + cedula + " eliminado.");
                        i = listaSocios.size();
                    }
                }
		    }else{
		        System.out.println("La persona de cedula " + cedula + " no es un socio.");
		    }
	    }
        System.out.println(Mensaje_Saliendo + "Socio");
	}

    //Permite modificar los datos de los socios que esten en el sistema.
	public void ModificarSocio() {
		if(listaSocios.isEmpty()){System.out.println(Mensaje_No_Socios);}
		else{
		    System.out.println("_______Modificar_Socios________");
		
		    System.out.println(Mensaje_Ingrese_Cedula);
		    int cedula = scanner.nextInt(); scanner.nextLine();
            if (verificarSocio(cedula)){
                for(int i = 0; i < listaSocios.size(); i++) {
			        Socio socio = listaSocios.get(i);
			        if(socio.getCedula()==cedula) {
				        System.out.println("_____________________\n¿Qué quieres modificar? \n1- Cedula \n2- Nombre "
				                   + "\n3- Apellido \n4- Fecha de nacimiento "
				                   + "\n5- DirecciC3n \n6- Telefono \n7- Email \n8- Mensualidad \n0- Salir");
				        int opcionModificar = scanner.nextInt(); scanner.nextLine();
				        while(opcionModificar != 0) {
					        switch (opcionModificar) {
					        case 1:
						        System.out.print("Ingrese la nueva cedula: ");
						        cedula = scanner.nextInt(); scanner.nextLine();
						        if(!verificarSocio(cedula)){
						            socio.setCedula(cedula);
						            System.out.println("Cedula modificada exitosamente.");   
						        }else{System.out.println("La nueva cedula ya esta ingresada en el sistema.");}
						        break;
						    case 2:
						        System.out.print("Ingrese el nuevo nombre: ");
						        String nombre = scanner.nextLine();
						        socio.setNombre(nombre);
						        System.out.println("Nombre modificado exitosamente.");
						        break;
						    case 3:
						        System.out.print("Ingrese el nuevo apellido: ");
						        String apellido = scanner.nextLine();
						        socio.setApellido(apellido);
						        System.out.println("Apellido modificado exitosamente.");
						        break;
						    case 4:
						        System.out.print("Ingrese la nueva fecha de nacimiento (AAAA-MM-DD): ");
						        String FechaStr = scanner.nextLine();
						        LocalDate FechaNacimiento = LocalDate.parse(FechaStr);
						        socio.setFechaNacimiento(FechaNacimiento);
						        System.out.println("Fecha de nacimiento modificada exitosamente.");
						        break;
						    case 5:
						        System.out.println("___Modificando_dirección:___");
						        Direccion direccion = new Direccion();
						        direccion.ingresarDireccion();
						        socio.setDireccion(direccion);
						        System.out.println("__Dirección_modificada_exitosamente__.");
						        break;
						    case 6:
			                    int opcion = 0;
		                    	do{
			                        System.out.println("¿Quieres agregar un nuevo número telefonico o eliminarlo? \n1- Agregarlo, \n2- Eliminarlo  \n0- Ninguan de las opciones)");
			                        opcion = scanner.nextInt(); scanner.nextLine();
			                        switch(opcion){
			                            case 1:System.out.println("Agrega un nuevo numero teléfonico: ");
			                                int telefono = scanner.nextInt(); scanner.nextLine();
			                                boolean index = validar(telefono, 8);
		                                    while(index != true){
		                                        System.out.println("El teléfono ingresado tiene más o menos dijitos. Asegurese de que el teléfono tenga 8 dijitos.");
		                                        System.out.println("Ingrese el numero telefonico: ");
		                                        telefono = scanner.nextInt(); scanner.nextLine();
		                                        index = validar(telefono, 8);
		                                    }
			                                socio.agregarTelefono(telefono);
			                                break;
			                            case 2: System.out.println("Ingrese el teléfono que quieres eliminar: ");
			                            telefono = scanner.nextInt(); scanner.nextLine();
			                            socio.eliminarTelefono(telefono);
			                            break;
			                            case 0: break;
			                            default: System.out.println(Mensaje_Opcion_Invlida);
			                            break;
			                        }
			                    }while(opcion != 0);
						        break;
						    case 7:
						        System.out.print("Ingrese el nuevo email: ");
						        String email = scanner.nextLine();
						        socio.setEmail(email);
						        System.out.println("Email modificado exitosamente.");
						        break;
						    case 8:
						        System.out.print("Ingrese la nueva mensualidad: ");
						        double mensualidad = scanner.nextDouble(); scanner.nextLine();
						        socio.setMensualidad(mensualidad);
						        System.out.println("Mensualidad modificada exitosamente.");
						        break;
						    default:
						        System.out.println(Mensaje_Opcion_Invlida); break;
					        }
					    System.out.println("_____________________\n¿Qué quieres modificar? \n1- Cedula \n2- Nombre "
					                   + "\n3- Apellido \n4- Fecha de nacimiento \n5- Direccion \n6- TelC)fono \n7- Email "
					                   + "\n8- Mensualidad \n0- Salir");
					    opcionModificar = scanner.nextInt();
				    }
				    i = listaSocios.size();
			    } 
		    }
            }else{System.out.println("La persona de cedula " + cedula + " no es un socio.");}
		}
		System.out.println(Mensaje_Saliendo + "Socio");
	}

    //Permite ver los socios agregados al sistema.
	public void VerSocios() {
		if (listaSocios.isEmpty()) {System.out.println(Mensaje_No_Socios);}
		else {
			int opcion;
		    do{
		        System.out.println("_______Ver_Socio/s________");
		        System.out.println("¿Qué quieres hacer? \n1- Ver un socio en especifico \n2- Ver todos los socios \n0- Salir");
		        opcion = scanner.nextInt(); scanner.nextLine();
		        switch(opcion){
		            case 1:
		                System.out.println(Mensaje_Ingrese_Cedula);
		                int cedula = scanner.nextInt(); scanner.nextLine();
		                if(verificarSocio(cedula)){
		                    for(int i = 0; i < listaSocios.size(); i++) {
				                Socio socios = listaSocios.get(i);
				                if(socios.getCedula() == cedula){
				                    System.out.println( "\n__________________\n"+ socios.toString() + "\n__________________\n");
				                }
			                }
		                }else{
		                    System.out.println("No existe un socio con la cedula " + cedula);
		                }
		                break;
		            case 2:
		                for(int i = 0; i < listaSocios.size(); i++) {
				            Socio socios = listaSocios.get(i);
				            System.out.println( "\n__________________\nCedula :"+ socios.getCedula() +"\nNombre: "+ socios.getNombre() + "\n__________________\n");
			            }
		                break;
		                case 0: break;
		            default: 
		            System.out.println(Mensaje_Opcion_Invlida);
		            break;
		        }
		    }while(opcion != 0);
		}
        System.out.println(Mensaje_Saliendo + "Socio");
	}
//Metodos de actividades
	//Metodo para berificar activdad
	public boolean verificarActividad(String nombre){
	    boolean tfActividad = false;
	    
	    if(!listaActividades.isEmpty()) {
			for (int i = 0; i < listaActividades.size(); i ++) {
				Actividad actividadBuscada = listaActividades.get(i);
				if(actividadBuscada.getNombre().equals(nombre)) {
					tfActividad = true;
				}
			}
		}
		
	    return tfActividad;
	}
    //Metodo para agregar actividad
	public void AgregarActividad() {
		System.out.println("_______Agregar_Actividad________");
		Actividad actividad = new Actividad();
		
		System.out.println(Mensaje_Ingrese_Nombre);
		String nombre = scanner.nextLine();
		
		if(!verificarActividad(nombre)){
		    actividad.setNombre(nombre);
		    actividad.ingresarDatosActividad(scanner);
		    listaActividades.add(actividad);
		    System.out.println("La actividad fu agregada al sistema exitisamente.");
		}else{
		    System.out.println("La actividad " + nombre + " ya esta en el sistema.");
		}
		System.out.println(Mensaje_Saliendo+"Actividad");
	}
    //Metodo para eliminar actividad
	public void EliminarActividad() {
	    if(listaActividades.isEmpty()){
	        System.out.println(Mensaje_No_Actividades);
	    }else{
		    System.out.println("_______Eliminar_Actividad________");

		    System.out.println(Mensaje_Ingrese_Nombre);
		    String nombre = scanner.nextLine();
        
            if(verificarActividad(nombre)){
    		    for(int i = 0; i < listaActividades.size(); i++) {
	    		    Actividad actividad = listaActividades.get(i);
		    	    if(actividad.getNombre().equals(nombre)) {
			    	    listaActividades.remove(i);
				        System.out.println("Actividad " + nombre + " eliminada.");
				        i = listaActividades.size();
    			    }
    		    }
		    }else{
		        System.out.println("La actividad " + nombre + " no esta en el sistema.");
		    }
	    }
	    System.out.println(Mensaje_Saliendo+"Actividad");
	}
    //Metodo para modificar actividad
	public void ModificarActividad() {
	    if(listaActividades.isEmpty()){System.out.println(Mensaje_No_Actividades);}
	    else{
	        System.out.println("_______Modificar_Actividades________");
	        System.out.println(Mensaje_Ingrese_Nombre);
	        String nombre = scanner.nextLine();
	        if (verificarActividad(nombre)) {
                for (int i = 0; i < listaActividades.size(); i++) {
                    Actividad actividad = listaActividades.get(i);
                    if (actividad.getNombre().equals(nombre)) {
                        System.out.println("_____________________\n¿Qué quieres modificar? \n1- Nombre \n2- Horario "
                                   + "\n0- Salir");
                        int opcionModificar = scanner.nextInt(); scanner.nextLine();
                        while (opcionModificar != 0) {
                            switch (opcionModificar) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre de la actividad: ");
                                    nombre = scanner.nextLine();
                                    if (!verificarActividad(nombre)) {
                                        actividad.setNombre(nombre);
                                        System.out.println("Nombre de actividad modificado exitosamente.");
                                    } else {System.out.println("Ya existe una actividad con ese nombre. No se pudo modificar.");}
                                    break;

                                case 2:
                                    System.out.println("Modificando horario de la actividad:");
                                    actividad.ingresarDatosActividad(scanner);
                                    System.out.println("Horario modificado exitosamente.");
                                    break;
                                case 0: break;
                                default:
                                    System.out.println(Mensaje_Opcion_Invlida); break;
                            }
                            System.out.println("_____________________\n¿Qué quieres modificar? \n1- Nombre \n2- Horario "
                                       + "\n0- Salir");
                            opcionModificar = scanner.nextInt(); scanner.nextLine(); 
                        }
                    
                    }
                }
            }else{System.out.println("La actividad " + nombre + " no esta en el sistema.");}
	    }
	    System.out.println(Mensaje_Saliendo+"Actividad");
	}
    //Metodo para ver actividad
	public void VerActividades() {
		if (listaActividades.isEmpty()) {System.out.println(Mensaje_No_Actividades);} 
		else {
		    int opcion;
		    do{
		        System.out.println("_______Ver_Actividad/es________");
		        System.out.println("¿Qué quieres hacer? \n1- Ver una actividad en especifico \n2- Ver todas las actividades \n0- Salir");
		        opcion = scanner.nextInt(); scanner.nextLine();
		        switch(opcion){
		            case 1:
		                System.out.println(Mensaje_Ingrese_Nombre);
		                String nombre = scanner.nextLine();
		                if(verificarActividad(nombre)){
		                    for(int i = 0; i < listaActividades.size(); i++) {
				                Actividad actividad = listaActividades.get(i);
				                if(actividad.getNombre().equals(nombre)){
				                    System.out.println( "\n__________________\n"+ actividad.toString() + "\n__________________\n");
				                    i = listaActividades.size();
				                }
			                }
		                }else{System.out.println("No existe una actividad con el nombre " + nombre);}
		                break;
		            case 2:
		                for(int i = 0; i < listaActividades.size(); i++) {
				            Actividad actividad = listaActividades.get(i);
				            System.out.println( "\n__________________\n"+ actividad.getNombre() + "\n__________________\n");
			            } break;
			        case 0: break;
		            default:
		                System.out.println(Mensaje_Opcion_Invlida); break;
		        }
		    }while(opcion != 0);
		}
        System.out.println(Mensaje_Saliendo+"Actividad");
	}
//Metodos de participaciones
	//Metodo para verificar participaciones
	public boolean verificarParticipacion(int cedula, String nombre){
	    boolean tfParticipacion = false;
	    if(!listaParticipaciones.isEmpty()) {
			for (int i = 0; i < listaParticipaciones.size(); i ++) {
			    Participa participacionBuscada = listaParticipaciones.get(i);
				if(participacionBuscada.getCedulaSocio() == cedula && participacionBuscada.getNombreActividad().equals(nombre)) {
					tfParticipacion = true;
					i = listaParticipaciones.size();
				}
	    	}
		}
	    return tfParticipacion;
	}
	//Metodo para agregar participaciones
	public void AgregarParticipacion(){
	    System.out.println("_______Agregar_Participacón________");
	    Participa participa = new Participa();
	    System.out.println(Mensaje_Ingrese_Cedula);
	    int cedula = scanner.nextInt(); scanner.nextLine();
	    if(verificarSocio(cedula)){
	        System.out.println(Mensaje_Ingrese_Nombre);
	        String nombre = scanner.nextLine();
	        if(verificarActividad(nombre)){
	            if(!verificarParticipacion(cedula, nombre)){
	                participa.setCedulaSocio(cedula);
	                participa.setNombreActividad(nombre);
	                listaParticipaciones.add(participa);
	                System.out.println("Participación agregada.");
	            }else{System.out.println("Participación del socio " + cedula + " con en actividad " + nombre + " ya existe.");}
	        }else{System.out.println("La actividad " + nombre + " no esta en el sistema.");}
	    }else{System.out.println("El socio " + cedula + " no esta en el sistema.");}
	    System.out.println(Mensaje_Saliendo+"Participa");
	}
	//Metodo para eliminar participaciones
	public void EliminarParticipacion(){
	   if(listaParticipaciones.isEmpty()){System.out.println(Mensaje_No_Participaciones);}
	   else{
	       System.out.println("_______Eliminar_Participación________");
	       System.out.println(Mensaje_Ingrese_Cedula);
	       int cedula = scanner.nextInt(); scanner.nextLine();
	       if(verificarSocio(cedula)){
	           System.out.println(Mensaje_Ingrese_Nombre);
	           String nombre = scanner.nextLine();
	           if(verificarActividad(nombre)){
	               if(verificarParticipacion(cedula, nombre)){
	                    for(int i = 0; i < listaParticipaciones.size(); i++) {
	    		            Participa participacion = listaParticipaciones.get(i);
		    	            if(participacion.getCedulaSocio() == cedula && participacion.getNombreActividad().equals(nombre)) {
			    	            listaParticipaciones.remove(i);
				                System.out.println("La participacion de el socio " + cedula + " la actividad " + nombre + " ha sido eliminada.");
				                i = listaParticipaciones.size();
    			            }
    		            }
	                }else{System.out.println("Participación del socio " + cedula + " con en actividad " + nombre + " no existe.");}
	           }else{System.out.println("La actividad " + nombre + " no esta en el sistema.");}
	       }else{System.out.println("El socio " + cedula + " no esta en el sistema.");}
	   }System.out.println(Mensaje_Saliendo+"Participa");
	}
	//Metodo para ver participaciones
	public void VerParticipaciones(){
	    if (listaParticipaciones.isEmpty()) {System.out.println(Mensaje_No_Participaciones);}
		else {
	        System.out.println("_______Ver_Participaciones________");
	        for(int i = 0; i < listaParticipaciones.size(); i++) {
			Participa participacion = listaParticipaciones.get(i);
			System.out.println( "\n__________________\n"+ participacion.toString() +"\n__________________\n");
			}
	    }System.out.println(Mensaje_Saliendo+"Participa");
	}
}//En participaciones usamos los tres metodos de verificaciones,si uno no se cumple da error y no sige adelante.
//En ves de crear una variable boolean para que obtenga el valor de verificacion, llamamos directamente a los metodos de verificacion corresepondientes y si es nesesario lo negamos.
//Despues de cada scanner.nextInt(); o scanner.nextDouble(); se puso un scanner.nextLine para que consumir el salto de linea.