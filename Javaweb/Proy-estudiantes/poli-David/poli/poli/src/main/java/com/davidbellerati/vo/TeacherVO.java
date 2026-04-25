/*
 * Descripcion -
 *   Modelo VO que encapsula propiedades comunes de un profesor.
 *
 * Ultima modificacion -
 *   15/11/2025 2:54 a. m
 *
 * Autores -
 *   David Bellerati
 *   Natan Souza
*/

package com.davidbellerati.vo;

import java.time.LocalDate;

public class TeacherVO extends HumanVO {

    public TeacherVO() { super(); }

    public TeacherVO(
            /*
             * HumanVO
            */
            int ci, LocalDate dateOfBirth, int phoneNumber,
            String name, String homeAddress, String emergencyService,

            /*
             * TeacherVO
            */
            float salary
    ) {
        super(ci, dateOfBirth, phoneNumber, name, homeAddress, emergencyService);
        this.salary = salary;
    }

    protected float salary;

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }


    /*
     * Devuelve un string con las propiedades.
     * @return String
     */
    @Override
    public String toString() {
        return "TeacherVO{" +
                "id=" + id +
                ", ci=" + ci +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + getAge() +
                ", phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", emergencyService='" + emergencyService + '\'' +
                ", salary=" + salary +
                '}';
    }

    /*
     * Verifica si el profesor recibe salario.
     */
    protected boolean hasSalary() {
        return this.salary > 0;
    }
}
