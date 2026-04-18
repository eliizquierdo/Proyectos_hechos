package com.alanlauradavid.controller;

import com.alanlauradavid.model.*;
import java.util.*;

public class MaterialController {
	
	private ArrayList<Material> listOfMaterials = new ArrayList<Material>();
	private Scanner userInput = new Scanner(System.in);
	
	@SuppressWarnings("unlikely-arg-type")
	public void handleInfo() {
		
		System.out.println(
				"""
				Ingrese una opcion valida:
				 [1] : Registrar articulo.
				 [2] : Remover articulo.
				 [3] : Verificar estado de articulo.
				 [4] : Establecer estado de articulo.
				 [5] : Ver informacion de articulo.
				"""			
		);
		
		int choice = userInput.nextInt();
		switch(choice) {
			case 1:
				Material material = new Material();
				
				material.setState(userInput.nextLine());
				material.setMaterialType(userInput.nextLine());
				
				material.setCuantity(userInput.nextInt());
				userInput.nextLine();
				
				material.setAmount(userInput.nextInt());
				userInput.nextLine();
				
				material.setArticleId(userInput.nextInt());
				userInput.nextLine();
				
				if (!listOfMaterials.contains(material)) {
					listOfMaterials.add(material);
				}
				
				break;
			
			case 2:
				userInput.nextLine();

			    System.out.print("Id del articulo: ");
			    int articleId = userInput.nextInt();

			    boolean finded = false;
			    for (Material m : listOfMaterials) {
			        if (m.getArticleId() == articleId){

			        	listOfMaterials.remove(m);
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Articulo no encontrado.");
			    }
			    
			    break;
			    
			case 3:
				userInput.nextLine();

			    System.out.print("Id del articulo: ");
			    articleId = userInput.nextInt();

			    finded = false;
			    for (Material m : listOfMaterials) {
			        if (m.getArticleId() == articleId){

			        	System.out.println(m.getState());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Articulo no encontrado.");
			    }
			    
				break;
				
			case 4:
				userInput.nextLine();

			    System.out.print("Id del articulo: ");
			    articleId = userInput.nextInt();

			    finded = false;
			    for (Material m : listOfMaterials) {
			        if (m.getArticleId() == articleId){

			        	m.setState(userInput.nextLine());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Articulo no encontrado.");
			    }
			    
				break;
			case 5:
				userInput.nextLine();

			    System.out.print("Id del articulo: ");
			    articleId = userInput.nextInt();

			    finded = false;
			    for (Material m : listOfMaterials) {
			        if (m.getArticleId() == articleId){

			        	System.out.println(m.toString());
			            finded = true;
			            break;
			        }
			    }
			    if (!finded) {
			        System.out.println("Articulo no encontrado.");
			    }
			    
			    break;
		}
	}
	
}
