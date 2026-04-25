package ejercicios.clasesabstractas;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class Chequera extends Cuenta {

    public Chequera(int numeroCuenta) {
        super(numeroCuenta, "Chequera");
    }

    @Override
    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String getTipoCuenta() {
        return this.tipoC;
    }
}