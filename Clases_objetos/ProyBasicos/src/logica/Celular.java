package logica;
public class Celular{
    private String marca;
    private String modelo;
    private int precio;
    private int codigo;
    
    public Celular(){
        
    }
    
    public Celular(String mar, String mod, int pre, int cod){
        marca = mar;
        modelo = mod;
        precio = pre;
        codigo = cod;
    }
    
    public String getMarca(){
        return marca;
    }
    
     public String getModelo(){
        return modelo;
    }
    
     public int getPrecio(){
        return precio;
    }
    
     public int getCodigo(){
        return codigo;
    }
    
    public void setMarca(String marc){
        this.marca = marc;
    }
    
    public void setModelo(String mode){
        this.modelo = mode;
    }
    
    public void setPrecio(int prec){
        this.precio = prec;
    }
    
    public void setCodigo(int codi){
        this.codigo = codi;
    }
    
    @Override
    public String toString(){
        return "Marca ="+marca + ", modelo ="+modelo +", precio ="+precio+ ",codigo ="+codigo;
    }
}
