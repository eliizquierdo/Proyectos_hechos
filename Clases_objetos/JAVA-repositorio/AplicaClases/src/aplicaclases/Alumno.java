package aplicaclases;

public class Alumno
{
    private String nombre;
    private Double n1, n2, n3;
    private Double prom;
    
    public Alumno(String nombre, Double n1, Double n2, Double n3)
    {
        this.nombre = nombre;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.prom = (n1+n2+n3)/3;
    }
    
    public void setNombre()
    {
        this.nombre = nombre;
    }
    
    public void setN1()
    {
        this.n1 = n1;
    }
    
    public void setN2()
    {
        this.n2 = n2;
    }
    
    public void setN3()
    {
        this.n3 = n3;
    }
    
    public void setProm()
    {
        this.prom = (n1+n2+n3)/3;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public Double getN1()
    {
        return n1;
    }
    
    public Double getN2()
    {
        return n2;
    }
    
    public Double getN3()
    {
        return n3;
    }
    
    public Double getProm()
    {
        return prom;
    }
    
    public String toString()
    {
        String estado = "<<Estado del Alumno>>\n\n";
        estado+="Nombre: "+nombre+"\n";
        estado+="Nota 1: "+n1+"\n";
        estado+="Nota 2: "+n2+"\n";
        estado+="Nota 3: "+n3+"\n\n";
        estado+="Promedio: "+prom+"\n";
        return estado;
    }
}
