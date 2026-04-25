package ejercicios.clasesabstractas;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public abstract class Cuenta {
    protected int numeroCuenta;
    protected double saldo;
    protected String tipoC;

    public Cuenta(int numeroCuenta, String tc) {
        this.setNumeroCuenta( numeroCuenta );
        this.tipoC = tc;
        this.saldo = 0.0;
    }

    /**
     * @return the numeroCuenta
     */
    public abstract int getNumeroCuenta();

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the saldo
     */
    public abstract double getSaldo();

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public abstract String getTipoCuenta();
}