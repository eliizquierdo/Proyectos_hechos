package com.alanlauradavid.model;

public class Member extends Person {
	boolean memberShipActive;
	
	public Member() {
		super();
		memberShipActive = true;
	}
	public Member(
			int CI,
			
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
		
		this.memberShipActive = true;
	}
	
	public boolean isMemberShipActive() {
		return memberShipActive;
	}
	public void setMemberShipActive(boolean memberShipActive) {
		this.memberShipActive = memberShipActive;
	}
	@Override
	public String toString() {
		return "Member [CI=" + CI + ", name=" + name + ", surname=" + surname + ", direction=" + direction
				+ ", emergencyService=" + emergencyService + ", membership=" + memberShipActive +"]";
	}
	
}
