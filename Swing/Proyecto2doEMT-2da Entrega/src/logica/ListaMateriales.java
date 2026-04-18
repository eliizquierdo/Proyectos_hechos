package logica;

import java.util.ArrayList;

public class ListaMateriales {

	private ArrayList <Materiales> listamateriales;
		
		public ListaMateriales(){
			listamateriales = new ArrayList<Materiales>();
		}
		
		public ArrayList<Materiales> getListaMateriales() {
			return listamateriales;
		}

		public void setListaMateriales(ArrayList<Materiales> listamateriales) {
			this.listamateriales = listamateriales;
		}
		
		public void agregar (Materiales s){
			listamateriales.add(s);
		}
		
		public void eliminar (Materiales m){
			listamateriales.remove(m);
		}
		
		public Materiales obtenerXCodigo(int codigo){
			
			for(int i= 0; i<listamateriales.size(); i++){
				
				if (listamateriales.get(i).getCodigo()==codigo){
					return listamateriales.get(i);
				}	
			}
			return null;
			
		}
		
		 public int largo(){
			   int cant=0;
			   
			   if (this!=null)
				   cant=listamateriales.size();
			   return cant;
				   
		   }
		
		public Materiales devolver(int i){
			   return (listamateriales.get(i));
		   }
		
		public void listarMateriales(){
			
			
			if (listamateriales.size() == 0) {
				System.out.println("\nNo hay materiales agreagados. \n" );
				
			}else {
		
				for(int i= 0; i<listamateriales.size(); i++){
					System.out.println((listamateriales.get(i)).toString()+ "\n");
				}
			}
			
		}		

}