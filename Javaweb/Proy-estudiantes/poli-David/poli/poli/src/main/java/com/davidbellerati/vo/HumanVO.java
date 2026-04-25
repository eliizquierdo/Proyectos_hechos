/*
 * Descripcion -
 *   Modelo VO abstracto que encapsula propiedades comunes de un humano.
 *
 * Ultima modificacion -
 *   16/11/2025 1:55 a. m
 *
 * Autores -
 *   David Bellerati
 *   Natan Souza
*/

package com.davidbellerati.vo;

import java.time.LocalDate;
import java.time.Period;

public abstract class HumanVO {

    public HumanVO() { }
    /*
     * No se define el id por ser AUTO_INCREMENT en la tabla correspondiente.
     */
    public HumanVO(
            int ci, LocalDate dateOfBirth, int phoneNumber,
            String name, String homeAddress, String emergencyService
    ) {
        this.ci = ci;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;

        this.name = name;
        this.homeAddress = homeAddress;
        this.emergencyService = emergencyService;
    }

    protected int id;
    protected int ci;
    protected LocalDate dateOfBirth;
    protected int phoneNumber;

    protected String name;
    protected String homeAddress;
    protected String emergencyService;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCI() { return ci; }
    public void setCI(int ci) { this.ci = ci; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public int getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public String getEmergencyService() { return emergencyService; }
    public void setEmergencyService(String emergencyService) { this.emergencyService = emergencyService; }

    /*
     * Devuelve un string con las propiedades.
     * @return String
     */
    @Override
    public String toString() {
        return "HumanVO{" +
            "id=" + id +
            ", ci=" + ci +
            ", dateOfBirth=" + dateOfBirth +
            ", phoneNumber=" + phoneNumber +
            ", name='" + name + '\'' +
            ", homeAddress='" + homeAddress + '\'' +
            ", emergencyService='" + emergencyService + '\'' +
            '}'
        ;
    }
    /*
     * Calcula la edad actual basándose en la fecha de nacimiento.
     * @return int
    */
    public int getAge() {
        if (getDateOfBirth() == null) return 0;
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }
    /*
     * Verifica si es adulto (18+).
     * @return boolean
     */
    public boolean isAnAdult() {
        return getAge() >= 18;
    }

}
