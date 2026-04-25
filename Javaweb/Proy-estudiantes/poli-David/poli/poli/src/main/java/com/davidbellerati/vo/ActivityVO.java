/*
 * Descripcion -
 *   Modelo VO abstracto que encapsula propiedades comunes de una actividad.
 *
 * Ultima modificacion -
 *   16/11/2025 2:28 a. m
 *
 * Autores -
 *   David Bellerati
 *   Natan Souza
*/

package com.davidbellerati.vo;

import java.util.List;

public class ActivityVO {
    

    public ActivityVO() {  }
    /*
     * No se define el id por ser AUTO_INCREMENT en la tabla correspondiente.
     */
    public ActivityVO(
        String name, String entryHour, String departHour,
        List<MemberVO> asignedMembers, TeacherVO asignedTeacher
    ) {
        this.name = name;
        this.entryHour = entryHour;
        this.departHour = departHour;
        this.asignedMembers = asignedMembers;
        this.asignedTeacher = asignedTeacher;
    }


    protected int id;
    protected String name;
    protected String entryHour; /* HH/MM */
    protected String departHour; /* HH/MM */
    protected List<MemberVO> asignedMembers;
    protected TeacherVO asignedTeacher;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEntryHour() { return entryHour; }
    public void setEntryHour(String entryHour) { this.entryHour = entryHour; }
    public String getDepartHour() { return departHour; }
    public void setDepartHour(String departHour) { this.departHour = departHour; }
    public List<MemberVO> getAsignedMembers() { return asignedMembers; }
    public void setAsignedMembers(List<MemberVO> asignedMembers) { this.asignedMembers = asignedMembers; }
    public TeacherVO getAsignedTeacher() { return asignedTeacher; }
    public void setAsignedTeacher(TeacherVO asignedTeacher) { this.asignedTeacher = asignedTeacher; }


    /*
     * Devuelve un string con las propiedades.
     * @return String
     */
    @Override
    public String toString() {
        return "ActivityVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entryHour='" + entryHour + '\'' +
                ", departHour='" + departHour + '\'' +
                ", asignedMembers=" + asignedMembers +
                ", asignedTeacher=" + asignedTeacher +
                '}';
    }
}
