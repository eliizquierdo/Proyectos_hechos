package com.alanlauradavid.model;

public class Activity {
	int price;
	int duration;
	int ageRequired;
	int memberAmount;
	String name;
	String schedule;
	String assignedTeacher;
	
	public Activity() {
		price 			 = 0;
		duration 		 = 0;
		ageRequired 	 = 0;
		memberAmount	 = 0;
		schedule 		 = "None";
		name 		 	 = "None";
		assignedTeacher  = "None";
	}
	
	public Activity(
			int price,
			int duration,
			int ageRequired,
			int memberAmount,
			String schedule,
			String name
		)
	{
		this.price 			 = price;
		this.duration 		 = duration;
		this.ageRequired 	 = ageRequired;
		this.memberAmount    = memberAmount;
		this.schedule 		 = schedule;
		this.name			 = name;
		this.assignedTeacher = "None";
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAgeRequired() {
		return ageRequired;
	}

	public void setAgeRequired(int ageRequired) {
		this.ageRequired = ageRequired;
	}

	public int getMemberAmount() {
		return memberAmount;
	}

	public void setMemberAmount(int memberAmount) {
		this.memberAmount = memberAmount;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAssignedTeacher(String name) {
		this.assignedTeacher = name;
	}
	
	public String getAssignedTeacher() {
		return assignedTeacher;
	}
	
	@Override
	public String toString() {
		return "Activity [price=" + price + ", duration=" + duration + ", ageRequired=" + ageRequired
				+ ", memberAmount=" + memberAmount + ", schedule=" + schedule + ", teacher=" + assignedTeacher +  "]";
	}
	
}
