package logica;

import java.util.ArrayList;

public class ListaPrestamos {
		
	private ArrayList <Prestamos> listaprestamos;
	
	public ListaPrestamos(){
		listaprestamos = new ArrayList<Prestamos>();
	}
	
	public ArrayList<Prestamos> getListaprestamos() {
		return listaprestamos;
	}

	public void setListaprestamos(ArrayList<Prestamos> listaprestamos) {
		this.listaprestamos = listaprestamos;
	}

	public void agregar (Prestamos p){
		listaprestamos.add(p);
	}
	
	public void eliminar (Prestamos p){
		listaprestamos.remove(p);
	}
	
	public void listarPrestamos(){
		
		if (listaprestamos.size() == 0) {
			System.out.println("\nNo hay prestamos agreagados. \n" );
			
		}else {
			
			for(int i= 0; i<listaprestamos.size(); i++){
				System.out.println((listaprestamos.get(i)).toString()+ "\n");
			}
		}	
	}
	 public int largo(){
		   int cant=0;
		   
		   if (this!=null)
			   cant=listaprestamos.size();
		   return cant;
			   
	   }
	
	public Prestamos devolver(int i){
		   return (listaprestamos.get(i));
	   }
}