package cuentas;

/**
 * @date 20/06/2018
 * @author Fredy Kcrez
 */
public class CuentaDeAhorros {
    private static double tasaInteresAnual = 0.10;
    private static int cantidadCuentas = 0;
    private double saldo;
    
    CuentaDeAhorros() {
        this.cantidadCuentas++;
    }

    /**
     * @return the tasaInteresAnual
     */
    public static double getTasaInteresAnual() {
        return tasaInteresAnual;
    }

    /**
     * @param aTasaInteresAnual the tasaInteresAnual to set
     */
    public static void setTasaInteresAnual(double aTasaInteresAnual) {
        tasaInteresAnual = aTasaInteresAnual;
    }

    /**
     * @return the cantidadCuentas
     */
    public static float getCantidadCuentas() {
        return cantidadCuentas;
    }

    /**
     * @param aCantidadCuentas the cantidadCuentas to set
     */
    public static void setCantidadCuentas(int aCantidadCuentas) {
        cantidadCuentas = aCantidadCuentas;
    }
    
    public double calcularInteresMensual() {
        return (this.getSaldo() * this.tasaInteresAnual) / 12;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}