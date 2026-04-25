/*
 * Descripcion -
 *   Modelo VO que encapsula propiedades comunes de un miembro.
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
import java.time.Period;

public class MemberVO extends HumanVO {

    public MemberVO() { super(); }

    public MemberVO(
            /*
             * HumanVO
            */
            int ci, LocalDate dateOfBirth, int phoneNumber,
            String name, String homeAddress, String emergencyService
    ) {
        super(ci, dateOfBirth, phoneNumber, name, homeAddress, emergencyService);
    }
    
    /*
     * Devuelve un string con las propiedades.
     * @return String
     */
    @Override
    public String toString() {
        return "MemberVO{" +
                "id=" + id +
                ", ci=" + ci +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + getAge() +
                ", phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", emergencyService='" + emergencyService + '\'' +
                '}';
    }

}
