package com.davidbellerati.vo;

import java.time.LocalDate;

public class EmployeeVO extends HumanVO {

    protected int id;
    protected String category;
    protected double salary;


    public EmployeeVO() {  }
    public EmployeeVO(
        int ci, LocalDate dateOfBirth, int phoneNumber,
        String name, String homeAddress, String emergencyService,
        String category, double salary
    ) {
        super(ci, dateOfBirth, phoneNumber, name, homeAddress, emergencyService);
        this.category = category;
        this.salary = salary;
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
