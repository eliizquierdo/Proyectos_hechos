package modelo.vo;

import java.util.Arrays;

public class EmpleadoVO {
    private int id;
    private String nombre;
    private String email;
    private String genero;
    private String departamento;
    private String cargo;
    private double salario;
    private String[] idiomas;
    private String[] habilidades;
    private boolean activo;
    private boolean tieneVehiculo;
    private boolean disponibleViajes;
    private String nivelEducacion;
    private String turno;
    private String fechaNacimiento;
    private String comentarios;

    public EmpleadoVO() {
    }

    public EmpleadoVO(int id, String nombre, String email, String genero, String departamento, 
                     String cargo, double salario, String[] idiomas, String[] habilidades, 
                     boolean activo, boolean tieneVehiculo, boolean disponibleViajes, 
                     String nivelEducacion, String turno, String fechaNacimiento, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.genero = genero;
        this.departamento = departamento;
        this.cargo = cargo;
        this.salario = salario;
        this.idiomas = idiomas;
        this.habilidades = habilidades;
        this.activo = activo;
        this.tieneVehiculo = tieneVehiculo;
        this.disponibleViajes = disponibleViajes;
        this.nivelEducacion = nivelEducacion;
        this.turno = turno;
        this.fechaNacimiento = fechaNacimiento;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String[] getIdiomas() { return idiomas; }
    public void setIdiomas(String[] idiomas) { this.idiomas = idiomas; }

    public String[] getHabilidades() { return habilidades; }
    public void setHabilidades(String[] habilidades) { this.habilidades = habilidades; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public boolean isTieneVehiculo() { return tieneVehiculo; }
    public void setTieneVehiculo(boolean tieneVehiculo) { this.tieneVehiculo = tieneVehiculo; }

    public boolean isDisponibleViajes() { return disponibleViajes; }
    public void setDisponibleViajes(boolean disponibleViajes) { this.disponibleViajes = disponibleViajes; }

    public String getNivelEducacion() { return nivelEducacion; }
    public void setNivelEducacion(String nivelEducacion) { this.nivelEducacion = nivelEducacion; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    @Override
    public String toString() {
        return "EmpleadoVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                ", departamento='" + departamento + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", idiomas=" + Arrays.toString(idiomas) +
                ", habilidades=" + Arrays.toString(habilidades) +
                ", activo=" + activo +
                ", tieneVehiculo=" + tieneVehiculo +
                ", disponibleViajes=" + disponibleViajes +
                ", nivelEducacion='" + nivelEducacion + '\'' +
                ", turno='" + turno + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}