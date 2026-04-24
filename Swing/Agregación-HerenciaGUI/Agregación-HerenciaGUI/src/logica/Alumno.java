package logica;

public class Alumno {
    private String apellido;
    private int grupo;
    private double cuotaBase;
    
    public Alumno() {   
    }

    public Alumno(String a, int g, double c) {
        apellido = a;
        grupo = g;
        cuotaBase = c;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String a) {
        apellido = a;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int g) {
        grupo = g;
    }

    public double getCuota() {
        return cuotaBase;
    }

    public void setCuota(double c) {
        cuotaBase = c;
    }

    
    
/**************************************************************************/
    public double cuotaNeta() {
        double monto = cuotaBase;
        
        if (grupo == 1 || grupo == 2)
            monto = cuotaBase * 0.75;
        if (grupo == 3 || grupo == 4)
            monto = cuotaBase * 0.90;
    
        return monto;
    }
/**************************************************************************/
    @Override
    public String toString() {
        return "\nApellido: " + apellido 
                + ", grupo: " + grupo
                + ", cuota base " + cuotaBase 
                +  ", cuota neta: " + cuotaNeta();
    }         
} // Fin de Alumno
