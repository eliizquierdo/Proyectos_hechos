//Empleado.java
package logica;

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



 @Override
 public String toString() {
     return  apellido + " " 
    		 + jornal + " "
    		 + dias + " ";
 }
}


