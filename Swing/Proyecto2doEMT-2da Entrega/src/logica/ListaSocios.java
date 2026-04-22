package logica;

import java.util.ArrayList;

public class ListaSocios {

	private ArrayList <Socios> listado;
		

		public ListaSocios(){
			listado = new ArrayList<Socios>();
		}
		
		public ArrayList<Socios> getListado() {
			return listado;
		}

		public void setListado(ArrayList<Socios> listado) {
			this.listado = listado;
		}
		
		public void agregar (Socios e){
			listado.add(e);
		}
		
		public void eliminar (Socios e){
			listado.remove(e);
		}
		
		public Socios obtenerXCedula(int cedula){
			
			for(int i= 0; i<listado.size(); i++){
				
				if (listado.get(i).getCedula()==cedula){
					return listado.get(i);
				}	
			}
			return null;		
		}
		
		public Socios devolver(int i){
			   return (listado.get(i));
		   }
		
		 public int largo(){
			   int cant=0;
			   
			   if (this!=null)
				   cant=listado.size();
			   return cant;
				   
		   }

		public void listarSocios(){
			
			if (listado.size() == 0) {
				System.out.println("\nNo hay socios agreagados. \n" );
				
			}else {
				for(int i= 0; i<listado.size(); i++){
					System.out.println((listado.get(i)).toString() + "\n");
				}
			
			}
		}	
}