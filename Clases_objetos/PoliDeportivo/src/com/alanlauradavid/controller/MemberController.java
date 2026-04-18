package com.alanlauradavid.controller;

import com.alanlauradavid.model.*;
import java.util.*;

public class MemberController {
	
	private ArrayList<Member> listOfMembers = new ArrayList<Member>();
	private Scanner userInput = new Scanner(System.in);
	
	@SuppressWarnings("unlikely-arg-type")
	public void handleInfo() {
		System.out.println(
			"""
			Ingrese una opcion valida:
			
			 [1] : Registrar miembro.
			 [2] : Remover miembro.
			 [3] : Ver informacion de miembro.
			"""
		);
		
		int choice = userInput.nextInt();
		switch(choice) {
			case 1:
				System.out.println(
					"""
					Ingrese los datos del nuevo miembro:
					 [1] : Cedula.
					 [2] : Nombre.
					 [3] : Apellido.
					 [4] : Direccion.
					 [5] : Servicio de emergencias.
					"""
				);
				
				Member member = new Member();
				member.setCI(userInput.nextInt());
				userInput.nextLine();
				
				member.setName(userInput.nextLine());
				member.setSurname(userInput.nextLine());
				member.setDirection(userInput.nextLine());
				member.setEmergencyService(userInput.nextLine());
				
				registerMember(member);
				break;
				
			case 2:
				 userInput.nextLine();

				    System.out.print("Nombre: ");
				    String memberName = userInput.nextLine();

				    System.out.print("Apellido: ");
				    String memberSurname = userInput.nextLine();

				    boolean finded = false;
				    for (Member m : listOfMembers) {
				        if (m.getName().equalsIgnoreCase(memberName)
				            && m.getSurname().equalsIgnoreCase(memberSurname)) {

				            listOfMembers.remove(m);
				            finded = true;
				            break;
				        }
				    }
				    if (!finded) {
				        System.out.println("Miembro no encontrado.");
				    }
				    break;
				
			case 3:
			    userInput.nextLine();

			    System.out.print("Nombre: ");
			    memberName = userInput.nextLine();

			    System.out.print("Apellido: ");
			    memberSurname = userInput.nextLine();

			    finded = false;
			    for (Member m : listOfMembers) {
			        if (m.getName().equalsIgnoreCase(memberName)
			            && m.getSurname().equalsIgnoreCase(memberSurname)) {

			            System.out.println(m.toString());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Miembro no encontrado.");
			    }
			    break;

		}
		
	}
	
	public void registerMember(Member member) {
		if (!listOfMembers.contains(member)) {
			listOfMembers.add(member);
		} else
			System.out.println("Miembro previamente registrado.");
	}
	
	public void showMembersInfo(Member member) {
		if (listOfMembers.contains(member)) {
			member.toString();
		}
	}
}
