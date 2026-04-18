package com.alanlauradavid.controller;

import com.alanlauradavid.model.*;
import java.util.*;

public class ActivityController {
	
	private ArrayList<Activity> listOfActivities = new ArrayList<Activity>();
	private Scanner userInput = new Scanner(System.in);
	
	@SuppressWarnings("unlikely-arg-type")
	public void handleInfo() {
		
		System.out.println(
				"""
				Ingrese una opcion valida:
					
				 [1] : Registrar actividad.
				 [2] : Remover actividad.
				 [3] : Asignar profesor.
				 [4] : Ver informacion de actividad.
				"""			
		);
		
		int choice = userInput.nextInt();
		switch(choice) {
			case 1:
				System.out.println(
						"""
						Ingrese los datos del nuevo miembro:
						 [1] : Precio.
						 [2] : Duracion.
						 [3] : Edad requerida.
						 [4] : Cantidad de miembros.
						 [5] : Fecha.
						 [6] : Nombre.
						"""
				);
				
				Activity activity = new Activity();
				
				activity.setPrice(userInput.nextInt());
				userInput.nextLine();
				
				activity.setDuration(userInput.nextInt());
				userInput.nextLine();
				
				activity.setAgeRequired(userInput.nextInt());
				userInput.nextLine();
				
				activity.setMemberAmount(userInput.nextInt());
				userInput.nextLine();
				
				activity.setSchedule(userInput.nextLine());
				activity.setName(userInput.nextLine());
				
				if (!listOfActivities.contains(activity)) {
					listOfActivities.add(activity);
				}
				
				break;
			case 2:
				userInput.nextLine();

			    System.out.print("Nombre: ");
			    String activityName = userInput.nextLine();

			    boolean finded = false;
			    for (Activity a : listOfActivities) {
			        if (a.getName().equals(activityName)){

			        	listOfActivities.remove(a);
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Actividad no encontrada.");
			    }
			    break;
			    
			case 3:
				userInput.nextLine();

			    System.out.print("Nombre: ");
			    activityName = userInput.nextLine();
			    
			    System.out.print("Profesor: ");
			    String teacherName = userInput.nextLine();
			    
			    finded = false;
			    for (Activity a : listOfActivities) {
			        if (a.getName().equalsIgnoreCase(activityName)) {
			        	a.setAssignedTeacher(teacherName);
			        	System.out.println(a.getAssignedTeacher());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Actividad no encontrada.");
			    }
			    break;
			case 4:
				userInput.nextLine();

			    System.out.print("Nombre: ");
			    activityName = userInput.nextLine();
			    
			    finded = false;
			    for (Activity a : listOfActivities) {
			        if (a.getName().equalsIgnoreCase(activityName)) {
			        	System.out.println(a.toString());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Actividad no encontrada.");
			    }
			    break;
		}
	}
	
}
