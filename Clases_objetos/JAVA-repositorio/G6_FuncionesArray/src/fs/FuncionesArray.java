/*
 * Guía de laboratorio 06 - Programación 3 - 2012
 * Ejercicio 8: Buscar el número mayor, menor, el promedio y la lista ordenada.
 */
package fs;

/**
 * @date 17/06/2018
 * @author Fredy Kcrez
 */
public class FuncionesArray {

    public static void main(String[] args) {
        int[] arreglo = { 0,1,2,3,4,5,6,1,0,5,3,0,4,6,1,6,1,1,2,5,3 };
        int rep = 4, viejo = 2, nuevo = 5, inf = 4, sup = 9;
        
        System.out.println("Número de ceros en el arreglo: " + cuentaCeros(arreglo));
        System.out.println("Suma de los #s pares: " + sumaPares(arreglo));
        System.out.println("El # " + rep + " aparece " + cuentaRepeticiones(arreglo, rep) + " veces.");
        
        sustituye(arreglo, viejo, nuevo);
        System.out.println("\nSe ha sustituido el # " + viejo + " por " + nuevo);
        for(int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i] + " ");
        
        intercambia(arreglo, --inf, --sup);
        System.out.println("\n\nSe intercambiaron los valores de las posiciones " + ++inf + " y " + ++sup);
        for(int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i] + " ");
        
        invierte(arreglo);
        System.out.println("\n\nArreglo invertido");
        for(int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i] + " ");
        
        System.out.println("\n\nEl # mayor en el rango " + inf + " y " + sup + " es " + mayor(arreglo, --inf, --sup));
        System.out.println("El # mayor se ubica en la posición " + posMayor(arreglo, ++inf, ++sup));
        
        ordena2(arreglo);
        System.out.println("\nArreglo ordenado descendentemente");
        for(int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i] + " ");
        
        int[] arr2 = {1,2,3};
        if(iguales(arreglo, arr2))
            System.out.println("\n\nLos arreglos son iguales.");
        else
            System.out.println("\n\nLos arreglos son diferentes.");
    }
    
    public static int cuentaCeros(int Arr[]) {
        int ceros = 0;
        for (int i=0; i<Arr.length; i++){
            if(Arr[i] == 0)
                ceros++;
        }
        return ceros;
    }
    
    public static int sumaPares(int Arr[]) {
        int suma = 0;
        for(int i=0; i<Arr.length; i++) {
            if(Arr[i]%2 == 0)
                suma += Arr[i];
        }
        return suma;
    }
    
    public static int cuentaRepeticiones(int Arr[], int x) {
        int count = 0;
        for(int i=0; i<Arr.length; i++) {
            if(Arr[i] == x)
                count++;
        }
        return count;
    }
    
    public static void sustituye(int Arr[], int old, int nuevo) {
        for(int i=0; i<Arr.length; i++) {
            if(Arr[i] == old)
                Arr[i] = nuevo;
        }
    }
    
    public static void intercambia(int Arr[], int i, int j) {
        int aux = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = aux;
    }
    
    public static void invierte(int Arr[]) {
        int count = Arr.length;
        int[] temp = new int[count];
        
        for(int i=0; i<count; i++) {
            temp[i] = Arr[i];
        }
        for(int i=0; i<Arr.length; i++) {
            Arr[i] = temp[--count];
        }
    }
    
    public static int mayor(int A[], int inf, int sup) {
        int may = -1;
        
        for(int i=inf; i<=sup; i++) {
            if(A[i] > may)
                may = A[i];
        }
        return may;
    }
    
    public static int posMayor(int A[], int inf, int sup) {
        int may = -1, posMay = 0;
        
        for(int i=inf; i<=sup; i++) {
            if(A[i] > may) {
                may = A[i];
                posMay = i;
            }
        }
        return posMay;
    }
    
    public static void ordena2(int A[]) {
        int aux;
        for(int i=0; i<A.length; i++) {
            for(int j=i+1; j<A.length; j++){
                if( A[i] < A[j] ) {
                    aux = A[i];
                    A[i] = A[j];
                    A[j] = aux;
                }
            }
        }
    }
    
    public static boolean iguales(int A1[], int A2[]) {
        if(A1.equals(A2))
            return true;
        else
            return false;
    }
}