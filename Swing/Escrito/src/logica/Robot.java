package logica;

public class Robot {
 private int id;
 private String nombre;
 private int anio;
 
 //constructor específico
  
  public Robot(int id, String nom, int anio) {
	  setIdent(id);
	  setNombre(nom);
	  setAnio(anio);
  }
  
  public int getIdent(){
	  return id;
  }
  
  public void setIdent(int id){
	  this.id = id;
  }
  
  public String getNombre(){
	  return nombre;
  }
  
  public void setNombre(String nom){
	  this.nombre = nom;
  }
  
  public int getAnio(){
	  return anio;
  }
  
  public void setAnio(int anio){
	  this.anio = anio;
  }
}
