package empresa;

import java.util.Date;

/**
 * @date 18/06/2018
 * @author Fredy Kcrez
 */
public class Fecha {
    private int mes;                                // 1-12
    private int dia;                                // 1-31 con base en el mes
    private int anho;                               // cualquier año
    private Date fecha;

    private static final int[] diasPorMes =         // Dias de cada mes
        {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] meses =
        { "","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };

    // constructor:
    // llama a comprobarMes para confirmar el valor apropiado para el mes;
    // llama a comprobarDia para confirmar el valor apropiado para el día 
    Fecha(int elMes, int elDia, int elAnho) {
        this.mes = this.comprobarMes(elMes);
        this.anho = elAnho;
        this.dia = this.comprobarDia(elDia);
        
        System.out.printf("Constructor del objeto Fecha para la fecha %s\n", this);
    }
    
    public int getDiasPorMes() {
        return diasPorMes[this.mes];
    }
    
    private String siguienteMesP() {
        return meses[this.mes + 1];
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
        if((diaPrueba>0) && (diaPrueba<=diasPorMes[ getMes() ]))
            return diaPrueba;
        // comprueba si es año bisiesto
        if((getMes()==2) && (diaPrueba==29) && (getAnho()%400==0 || (getAnho()%4==0 && getAnho()%100 != 0 )))
            return diaPrueba;
        throw new IllegalArgumentException("Día fuera de rango para el mes y año especificados");
    }

    // devuelve un objeto String de la forma mes/dia/anio
    public String toString() {
        return String.format("%d/%d/%d", getMes(), getDia(), getAnho());
    }
    
    public void siguienteDia() {
        int diaPrueba = this.dia;
        int centinela;

        if(
                // comprueba si el día está dentro del rango para el mes
                ((diaPrueba>0) && (diaPrueba<diasPorMes[ getMes() ]))
                ||
                // comprueba si es año bisiesto
                ((getMes()==2) && (diaPrueba==28) && (getAnho()%400==0 || (getAnho()%4==0 && getAnho()%100 != 0 )))
            )
            centinela = 0;
        else
            centinela = 1;
        
        switch(centinela) {
            case 0:
                this.dia += 1;
                break;
            case 1:
                this.dia = 1;
                if((getMes()>0) && (getMes()<12))
                    this.mes += 1;
                else {
                    this.mes = 1;
                    this.anho += 1;
                }
                break;
        }
    }
    
    public String siguienteMes() {
        int mesPrueba = this.mes;

        if((mesPrueba>0) && (mesPrueba<12))
            return this.siguienteMesP();
        else
            return "Enero";
    }
    
    public int siguienteAnho() {
        return this.anho + 1;
    }
    
    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the anho
     */
    public int getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(int anho) {
        this.anho = anho;
    }
}