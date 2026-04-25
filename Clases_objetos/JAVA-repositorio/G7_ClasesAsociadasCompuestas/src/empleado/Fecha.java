/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleado;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Fecha {
    private int mes;                                // 1-12
    private int dia;                                // 1-31 con base en el mes
    private int anho;                               // cualquier año

    private static final int[] diasPorMes =         // Dias de cada mes
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructor:
    // llama a comprobarMes para confirmar el valor apropiado para el mes;
    // llama a comprobarDia para confirmar el valor apropiado para el día 
    Fecha(int elMes, int elDia, int elAnho) {
        this.mes = this.comprobarMes(elMes);
        this.anho = elAnho;
        this.dia = this.comprobarDia(elDia);
        
        System.out.printf("Constructor del objeto Fecha para la fecha %s\n", this);
    }

    // método utilitario para confirmar el valor apropiado del mes
    private int comprobarMes(int mesPrueba) {
        if((mesPrueba>0) && (mesPrueba<=12))
            return mesPrueba;
        else
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
    }

    // método utilitario para confirmar el valor apropiado del día, con base    // en el mes y el año
    private int comprobarDia(int diaPrueba) {
        // comprueba si el día está dentro del rango para el mes
        if((diaPrueba>0) && (diaPrueba<=diasPorMes[ mes ]))
            return diaPrueba;
        // comprueba si es año bisiesto
        if((mes==2) && (diaPrueba==29) && (anho%400==0 || (anho%4==0 && anho%100 != 0 )))
            return diaPrueba;
        throw new IllegalArgumentException("Día fuera de rango para el mes y año especificados");
    }

    // devuelve un objeto String de la forma mes/dia/anio
    public String toString() {
        return String.format("%d/%d/%d", mes, dia, anho);
    }
}