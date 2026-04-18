//Empleado.java
package modelo;

public class Empleado {
 private String apellido;
 private double jornal;
 private int dias;

 //constructor
 public Empleado(String apellido, double jornal, int dias) {
     this.apellido = apellido;
     this.jornal = jornal;
     this.dias = dias;
 }

 //Método especifico
 public double sueldo() {
     return jornal * dias;
 }

 @Override
 public String toString() {
     return  apellido + " " 
    		 + jornal + " "
    		 + dias + " "
    		 + sueldo();
 }
}


