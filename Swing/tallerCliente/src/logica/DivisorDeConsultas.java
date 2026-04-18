package logica;

import java.util.ArrayList;

public class DivisorDeConsultas {
	
	private static DivisorDeConsultas instancia;
	
	private ArrayList<String> listaConsultas;
	
	public static DivisorDeConsultas getInstance() {
		if(instancia==null) {
			instancia = new DivisorDeConsultas();
		}
		return instancia;
	}
	
	private DivisorDeConsultas(){
		this.listaConsultas=new ArrayList<String>();
	}
	
	public void mandarConsultas(String consultas) {
		dividirConsultasYAgregar(consultas);
		while(listaConsultas.size()>0) {
			Cliente.getInstance().realizarConsulta(listaConsultas.get(0));
			listaConsultas.remove(0);
		}
	}
	
	private void dividirConsultasYAgregar(String consultas) {
		String[] consultasDivididas=consultas.split(";");
		for(String consulta : consultasDivididas) {
			if(!consulta.isBlank()) {
				while(consulta.contains("  ")) {
					consulta=consulta.replace("  ", " ");
				}
				this.listaConsultas.add(consulta.trim());
			}
		}
	}
	
}
