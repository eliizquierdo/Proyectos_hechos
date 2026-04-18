package echeveste;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {


	
		 String[] Calendario = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
	        Scanner Agenda = new Scanner(System.in);
	       
	        System.out.println("Seleccione el dia que quieras:");
            System.out.println("Lunes:");
            System.out.println("Martes:");
            System.out.println("Miercoles:");
            System.out.println("Jueves:");
            System.out.println("Viernes:");
            System.out.println("Sabado:");
            System.out.println("Domingo:");
	     System.out.println("---------------------------------------");
            
	     for (int dia = 0; dia < Calendario.length; dia++) {
	            System.out.println("Ingrese un Numero para saber que tienes agendado para  un dia de la semana: ");
	            int Nro = Agenda.nextInt();

	            
	            if (Nro == 0) {
	                System.out.println("El día " + Calendario[dia] + " Tienes agendado ir al gym");
	                System.out.println("--------------------------------");
	            }  if (Nro == 1) {
	                System.out.println("El día " + Calendario[dia] + " Tienes agendado Estudiar para Programación");
	                System.out.println("--------------------------------");

	            }  if (Nro == 2) {
	                System.out.println("El día " + Calendario[dia] + " No tienes nada agendado para hoy");
	                System.out.println("--------------------------------");

	            }  if (Nro == 3) {
	                System.out.println("El día " + Calendario[dia] + " Tienes agendado A la Hora 14:00 ir a jugar fútbol con los pibes");
	                System.out.println("--------------------------------");

	            }  if (Nro == 4) {
	                System.out.println("El día " + Calendario[dia] + " Tienes agendado ir al Dentista");
	                System.out.println("--------------------------------");

	            }  if (Nro == 5) {
	                System.out.println("El día " + Calendario[dia] + " No tienes nada agendado para hoy");
	                System.out.println("--------------------------------");

	            } 
	            if (Nro == 6) {
	                System.out.println("El día " + Calendario[dia] + " Tienes agendado Salir de fiesta");
      Agenda.close();            }
	        }
	    }
	}
