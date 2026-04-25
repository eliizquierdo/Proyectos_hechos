/*
 * Guía de laboratorio 07 - Programación 3 - 2012
 * Ejercicio 2:
 * En un paquete cuentas, cree una clase llamada CuentaDeAhorros. Use una variable static llamada 
 * tasaInteresAnual para almacenar la tasa de interés anual para todas las cuentas. Use otra variable static 
 * llamada cantidadCuentas que almacene la cantidad de cuentas existentes, establezca su valor a 0; esta variable 
 * debe incrementar cada vez que se invoque el constructor de la clase. Incluya un método llamado 
 * getCantidadCuentas para obtener el número de cuentas existentes. Cada objeto de la clase debe contener una 
 * variable de instancia private llamada saldo, que indique la cantidad que el ahorrador tiene actualmente en 
 * depósito. Proporcione el método calcularInteresMensual para calcular el interés mensual, multiplicando el 
 * saldo por la tasa de interés anual y dividiéndolo entre 12; este interés debe sumarse al saldo. Proporcione un 
 * método estático llamado modificarTasaInteres para establecer la tasaInteresAnual en un nuevo valor. Agregue 
 * la clase PruebaCuenta para probar la clase CuentaDeAhorros. En la prueba, cree dos cuentas de ahorros, 
 * ahorro1 y ahorro2, con saldos de $2,000.00 y $3,000.00. Establezca la tasa de interés anual a 1.5%, después 
 * calcule el interés mensual para cada uno de los 12 meses e imprima los nuevos saldos de las cuentas. Luego 
 * establezca la tasa de interés anual a 2.5%, calcule el interés del siguiente mes e imprima los nuevos saldos. 
 * Finalmente, imprima la cantidad de cuentas existentes. 
 */
package cuentas;

/**
 * @date 20/06/2018
 * @author Fredy Kcrez
 */
public class PruebaCuentas {

    public static void main(String[] args) {
        CuentaDeAhorros ahorro1 = new CuentaDeAhorros();
        CuentaDeAhorros ahorro2 = new CuentaDeAhorros();
        
        ahorro1.setSaldo(2000.00);
        ahorro2.setSaldo(3000.00);
        
        CuentaDeAhorros.setTasaInteresAnual(0.015);
        System.out.printf("- Cuenta de ahorro 1 -\nInteres mensual: $%.2f", ahorro1.calcularInteresMensual());
        System.out.printf("\nSaldo mensual:");
        for(int i=0; i<12; i++) {
            ahorro1.setSaldo(ahorro1.getSaldo() + ahorro1.calcularInteresMensual());
            System.out.printf("\nMes %d: $%.2f", (i+1), ahorro1.getSaldo());
        }
        System.out.printf("\n\n- Cuenta de ahorro 2 -\nInteres mensual: $%.2f", ahorro2.calcularInteresMensual());
        System.out.printf("\nSaldo mensual:");
        for(int i=0; i<12; i++) {
            ahorro2.setSaldo(ahorro2.getSaldo() + ahorro2.calcularInteresMensual());
            System.out.printf("\nMes %d: $%.2f", (i+1), ahorro2.getSaldo());
        }
        
        CuentaDeAhorros.setTasaInteresAnual(0.025);
        System.out.printf("\n\n\n\n- Cuenta de ahorro 1 -\nInteres mensual: $%.2f", ahorro1.calcularInteresMensual());
        System.out.println("\nSaldo mensual:");
        for(int i=0; i<12; i++) {
            ahorro1.setSaldo(ahorro1.getSaldo() + ahorro1.calcularInteresMensual());
            System.out.printf("\nMes %d: $%.2f", (i+1), ahorro1.getSaldo());
        }
        System.out.println("\n\n- Cuenta de ahorro 2 -\nInteres mensual: $" + ahorro2.calcularInteresMensual());
        System.out.println("\nSaldo mensual:");
        for(int i=0; i<12; i++) {
            ahorro2.setSaldo(ahorro2.getSaldo() + ahorro2.calcularInteresMensual());
            System.out.printf("\nMes %d: $%.2f", (i+1), ahorro2.getSaldo());
        }
        
        System.out.println("\n\nCantidad de cuentas existentes: " + CuentaDeAhorros.getCantidadCuentas());
    }
}