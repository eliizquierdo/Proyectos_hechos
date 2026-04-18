package modelo.vo;

import java.util.Arrays;

public class EmpleadoVO {
    private int id;
    private String nombre;
    private String email;
    private String genero; // Radio button
    private String departamento; // Select simple
    private double salario;
    private String[] idiomas; // Select múltiple
    private boolean activo; // Checkbox individual
    private String comentarios; // Textarea

    //  Los estudiantes pueden agregar más campos para practicar:
    // - String cargo; // Otro select
    // - String[] habilidades; // Más checkboxes múltiples
    // - String turno; // Más radio buttons
    // - boolean tieneVehiculo; // Más checkboxes individuales
    // - String fechaNacimiento; // Input date
    // - String nivelEducacion; // Otro select

    public EmpleadoVO() {
    }

    public EmpleadoVO(int id, String nombre, String email, String genero, String departamento,
            double salario, String[] idiomas, boolean activo, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.genero = genero;
        this.departamento = departamento;
        this.salario = salario;
        this.idiomas = idiomas;
        this.activo = activo;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "EmpleadoVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salario=" + salario +
                ", idiomas=" + Arrays.toString(idiomas) +
                ", activo=" + activo +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}