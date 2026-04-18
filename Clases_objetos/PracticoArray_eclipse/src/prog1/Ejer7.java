package prog1;
//sabatino

import java.util.Random;

public class Ejer7 {
	public static void main(String[] args) {
	
	Random azar = new Random();
	int nota;
	int acu=0;
	int calificaciones[]=new int [10];
	for(int i=0; i<10; i++) {
	nota=azar.nextInt(12)+1;
	calificaciones[i]=nota;
	}
	for(int i=0; i<10; i++) {
	acu = acu + calificaciones[i];
	}
	int promedio=acu/10;
	int a=notaMasBaja(calificaciones);
	int b=posMasBaja(calificaciones);
	int c=notaMasAlta(calificaciones);
	//int d=posMasAlta(calificaciones);
	System.out.println("La nota mas baja es: " + a);
	System.out.println("La nota mas baja es: " + a);
	System.out.println("La posicion mas baja es: " + b);
	System.out.println("La nota mas alta es: " + c);
	//System.out.println("La posicion mas alta es: " + d);
	}

public static int notaMasBaja(int array[]) {
int nota = array[0];
for(int i=1; i<10; i++) {
if(nota>array[i])
nota=array[i];
}
return nota;
}

public static int notaMasAlta(int array[]) {
int nota = array[0];
for(int i=1; i<10; i++) {
if(nota<array[i])
nota=array[i];
}
return nota;
}
public static int posMasBaja(int array[]) {
int pos = array[0];
for(int i=1; i<10; i++) {
if(pos>array[i])
pos=i;
}
return pos;

}
}