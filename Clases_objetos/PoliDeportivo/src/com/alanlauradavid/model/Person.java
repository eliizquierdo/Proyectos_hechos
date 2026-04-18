package com.alanlauradavid.model;

public abstract class Person {
	int CI;
	
	String name;
	String surname;
	String direction;
	String emergencyService;
	
	public Person() {
		this.CI 			  = 000000;
		this.name 			  = "Jhon";
		this.surname 		  = "Doe";
		this.direction		  = "None";
		this.emergencyService = "None";
	}
	
	public Person(
			int CI,
			
			String name, 
			String surname,
			String direction, 
			String emergencyService
		)
	{
		this.CI 			  = CI;
		this.name 			  = name;
		this.surname		  = surname;
		this.direction 		  = direction;
		this.emergencyService = emergencyService;
	}

	
	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getEmergencyService() {
		return emergencyService;
	}

	public void setEmergencyService(String emergencyService) {
		this.emergencyService = emergencyService;
	}

	@Override
	public String toString() {
		return "Person [CI=" + CI + ", name=" + name + ", surname=" + surname + ", direction=" + direction
				+ ", emergencyService=" + emergencyService + "]";
	}
	
}
