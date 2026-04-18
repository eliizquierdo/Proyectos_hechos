package logic;

import graphic.*;
import persistence.*;

public class InfoValueObject {
	private int id;
	private String name, nationality, occupation, achievement, description, date_b, date_d, img;
	
	public InfoValueObject() {
	}

	public InfoValueObject(int id, String name, String date_b, String date_d, String nationality, String occupation,
			String achievement, String description, String img) {
		this.id = id;
		this.name = name;
		this.date_b = date_b;
		this.date_d = date_d;
		this.nationality = nationality;
		this.occupation = occupation;
		this.achievement = achievement;
		this.description = description;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_b() {
		return date_b;
	}

	public void setDate_b(String date_b) {
		this.date_b = date_b;
	}

	public String getDate_d() {
		return date_d;
	}

	public void setDate_d(String date_d) {
		this.date_d = date_d;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return String.format("\nID: %s\nNombre: %s\nFecha nac: %s\nFecha def: %s\nNacionalidad: %s\nOcupación %s\nLogro: %s\nDescripción: %s\nImagen: %s", 
				id, name, date_b, date_d, nationality, occupation, achievement, description, img);
	}
}