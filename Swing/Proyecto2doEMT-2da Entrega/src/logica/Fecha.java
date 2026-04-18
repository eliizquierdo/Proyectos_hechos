package logica;

public class Fecha {

	private int dia;
	private int mes;
	private int anio;

	public Fecha(int dia, int mes, int anio) {	
		this.dia=dia;
		this.anio=anio;
		this.mes=mes;
	}

	private boolean esBisiesto() {
		return ((anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0));
	}

	public int getDia() {
		return dia;
	}
	
	public void setDia(int d) {
		dia = d;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int m) {
		mes = m;
	}
	
	public void setAnio(int a) {
		anio = a;
	}
	
	public int getAnio() {
		
		return anio;
	} 
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = (anio > 0);
		mesCorrecto = (mes >= 1) && (mes <= 12);
		
		switch (mes) {

			case 2:

				if (esBisiesto()) {
					diaCorrecto = (dia >= 1 && dia <= 29);

					} else {

					diaCorrecto = (dia >= 1 && dia <= 28);
					}
			break;

			case 4:
				diaCorrecto = (dia >= 1 && dia <= 30);
			break;	
				
			case 6:
				diaCorrecto = (dia >= 1 && dia <= 30);
			break;
				
			case 9:
				diaCorrecto = (dia >= 1 && dia <= 30);
			break;

			case 11:
				diaCorrecto = (dia >= 1 && dia <= 30);
			break;

			default:

				diaCorrecto = (dia >= 1 && dia <= 31);
			}

		return diaCorrecto && mesCorrecto && anioCorrecto;

	}
	
	public String mostrarFecha(){
		
		String mfecha= " ";
		
		if(fechaCorrecta()){
			mfecha= getDia() +"-"+ getMes() +"-"+ getAnio();
		}
		else{
			mfecha= "Fecha no valida";
		}
		
		return mfecha;
	}
	
	public boolean esMenor(Fecha f){
		boolean menor;
	
		if (this.getAnio()<f.getAnio())
			menor=true;
		else 
			if (this.getAnio()==f.getAnio()) 
					if (this.getMes()<f.getMes())
						menor=true;
					else 
						if (this.getMes()==f.getMes())
							if (this.getDia()<f.getDia())
								menor= true;
							else
								menor=false;
						else
							menor=false;
			else
				menor=false;
		return menor;
	}

}
