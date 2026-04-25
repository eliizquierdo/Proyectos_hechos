package parte2;

public class Principal {

	public static void main(String[] args) {
		
		Alumno a1=new Alumno("1234567",4000);
		Alumno a2=new Alumno("3456789",2000);
		Becado b1=new Becado("23334445",5000,500);
		Becado b2=new Becado("43332221",3000,300);
		Equipo e1=new Equipo(1,"estudio",a1,b1);
		Equipo e2=new Equipo(2,"repaso",a1,b2);
		Equipo e3=new Equipo(3,"práctica",a2,b2);
		System.out.println("Cedulas del Equipo  1: ");
		System.out.println("cedula alumno 1: "+e1.getAlu1().getCedula());
		System.out.println("cedula alumno 2: "+e1.getAlu2().getCedula());
		System.out.println("Cuotas del Equipo  2: ");
		e2.getAlu1().cuotaNeta(1);
		e2.getAlu2().cuotaNeta(2);
		
		
	}

}
