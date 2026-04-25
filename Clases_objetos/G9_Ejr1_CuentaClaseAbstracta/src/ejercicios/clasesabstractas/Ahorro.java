package ejercicios.clasesabstractas;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public class Ahorro extends Cuenta {
    protected double tasaInteres;

    public Ahorro(int numeroCuenta, double ti) {
        super( numeroCuenta, "Ahorro" );
        this.setTasaInteres( ti );
    }

    @Override
    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * @return the tasaInteres
     */
    public double getTasaInteres() {
        return tasaInteres;
    }

    /**
     * @param tasaInteres the tasaInteres to set
     */
    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    @Override
    public String getTipoCuenta() {
        return this.tipoC;
    }
}