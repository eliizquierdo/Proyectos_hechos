package com.alanlauradavid.model;

public class Teacher extends Person {
	
	private int salary;
	
	public Teacher() {
		super();
		this.salary = 24000;
	}
	public Teacher(
			int CI,
			int salary,
			String name, 
			String surname,
			String direction, 
			String emergencyService
		)
	{
		
		super(
			CI,
			name,
			surname,
			direction,
			emergencyService
		);
		
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Teacher [salary=" + salary + ", CI=" + CI + ", name=" + name + ", surname=" + surname + ", direction="
				+ direction + ", emergencyService=" + emergencyService + "]";
	}
	
	
}
