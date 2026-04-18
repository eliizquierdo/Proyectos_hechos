package com.alanlauradavid.controller;

import com.alanlauradavid.model.*;
import java.util.*;

public class TeacherController {
	
	private ArrayList<Teacher> listOfTeachers = new ArrayList<Teacher>();
	private Scanner userInput = new Scanner(System.in);
	
	@SuppressWarnings("unlikely-arg-type")
	public void handleInfo() {
		
		System.out.println(
			"""
			Ingrese una opcion valida:
				
			 [1] : Contratar profesor.
			 [2] : Despedir profesor.
			 [3] : Pagar sueldo a profesor.
			 [4] : Ver informacion del profesor.
			"""			
		);
		
		int choice = userInput.nextInt();
		switch(choice) {
			case 1:
				System.out.println(
						"""
						Ingrese los datos del nuevo miembro:
						 [1] : Cedula.
						 [2] : Sueldo.
						 [3] : Nombre.
						 [4] : Apellido.
						 [5] : Direccion.
						 [6] : Servicio de emergencias.
						"""
				);
				
				userInput.nextLine();
				
				Teacher teacher = new Teacher();
				teacher.setCI(userInput.nextInt());
				userInput.nextLine();
				
				teacher.setSalary(userInput.nextInt());
				userInput.nextLine();
				
				teacher.setName(userInput.nextLine());
				teacher.setSurname(userInput.nextLine());
				teacher.setDirection(userInput.nextLine());
				teacher.setEmergencyService(userInput.nextLine());

				if (!listOfTeachers.contains(teacher)) {
					listOfTeachers.add(teacher);
				}
				
				/*String nameOfTeacher = userInput.nextLine();
				String surnameOfTeacher = userInput.nextLine();
				for (Teacher t : listOfTeachers) {
					if (!t.getName().equals(nameOfTeacher) && !t.getSurname().equals(surnameOfTeacher)) {
						listOfTeachers.add(t);
					}
				}*/
				break;
				
			case 2:
				userInput.nextLine();

			    System.out.print("Nombre: ");
			    String teacherName = userInput.nextLine();

			    System.out.print("Apellido: ");
			    String memberSurname = userInput.nextLine();

			    boolean finded = false;
			    for (Teacher t : listOfTeachers) {
			        if (t.getName().equalsIgnoreCase(teacherName)
			            && t.getSurname().equalsIgnoreCase(memberSurname)) {

			            listOfTeachers.remove(t);
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Profesor no encontrado.");
			    }
			    break;
			case 3:
				userInput.nextLine();

			    System.out.print("Nombre: ");
			    teacherName = userInput.nextLine();

			    System.out.print("Apellido: ");
			    memberSurname = userInput.nextLine();

			    finded = false;
			    for (Teacher t : listOfTeachers) {
			        if (t.getName().equalsIgnoreCase(teacherName)
			            && t.getSurname().equalsIgnoreCase(memberSurname)) {

			            System.out.println("Paga realizada.");
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Profesor no encontrado.");
			    }
			    break;
			    
			case 4:
				userInput.nextLine();

			    System.out.print("Nombre: ");
			    teacherName = userInput.nextLine();

			    System.out.print("Apellido: ");
			    memberSurname = userInput.nextLine();

			    finded = false;
			    for (Teacher t : listOfTeachers) {
			        if (t.getName().equalsIgnoreCase(teacherName)
			            && t.getSurname().equalsIgnoreCase(memberSurname)) {

			            System.out.println(t.toString());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Profesor no encontrado.");
			    }
			    break;
		}
	}
	
}