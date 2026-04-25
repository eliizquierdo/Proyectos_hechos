
package logica;

public class Cliente {
    private String apellido;
    private int edad;
    private int antiguedad;
    private double salario;

    public Cliente() {
    }

    
    
    public Cliente(String apellido, int edad, int antiguedad, double salario) {
        this.apellido = apellido;
        this.edad = edad;
        this.antiguedad = antiguedad;
        this.salario = salario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public boolean darTarjeta(){
        return (edad >= 18 && antiguedad >= 6 && salario >= 20000);
    }
    
    public double saldoTarjeta() {
        double saldo = salario * 0.35;
        if (salario >= 40000)
            saldo = salario * 0.50;
        return saldo;
    }
    
    @Override
    public String toString() {
        return "-------------------------"
                + "\napellido: " + apellido
                + "\nedad: " + edad 
                + "\nantiguedad: " + antiguedad 
                + "\nsalario: " + salario 
                + "\n";
    } 
}
