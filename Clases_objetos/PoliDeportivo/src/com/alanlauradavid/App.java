package com.alanlauradavid;

import com.alanlauradavid.model.*;
import com.alanlauradavid.controller.*;
import java.util.*;

public class App {
	private static boolean isRunning;
	private static Scanner userChoice;
	private static MemberController memberController;
	private static TeacherController teacherController;
	private static ActivityController activityController;
	private static MaterialController materialController;

	public static void main(String[] args) {
		// Inicialización de los controladores
		memberController = new MemberController();
		teacherController = new TeacherController();
		activityController = new ActivityController();
		materialController = new MaterialController();

		// Estado de ejecución
		isRunning = true;

		// Iniciar Scanner (con try-with-resources para evitar problemas de cierre de
		// recurso)
		try (Scanner scanner = new Scanner(System.in)) {
			userChoice = scanner;

			// Ciclo de ejecución principal
			while (isRunning) {
				System.out.println(
						"""
								Ingrese una opción válida:

								 [1] : Miembros.
								 [2] : Profesores.
								 [3] : Actividades.
								 [4] : Materiales.
								 [5] : Salir.
								""");

				// Verificar que la entrada sea un número válido
				if (userChoice.hasNextInt()) {
					int option = userChoice.nextInt(); // Leer la opción seleccionada

					// Procesar la opción seleccionada
					switch (option) {
						case 1:
							memberController.handleInfo();
							break;

						case 2:
							teacherController.handleInfo();
							break;

						case 3:
							activityController.handleInfo();
							break;

						case 4:
							materialController.handleInfo();
							break;

						case 5:
							isRunning = false; // Salir
							break;

						default:
							System.out.println("Opción no válida, por favor intente de nuevo.");
							break;
					}
				} else {
					// Si la entrada no es un número entero
					System.out.println("Entrada no válida. Por favor ingrese un número.");
					userChoice.next(); // Limpiar el buffer del scanner
				}
			}
		} catch (Exception e) {
			System.out.println("Hubo un error al leer la entrada. Intente de nuevo.");
		}
	}
}
