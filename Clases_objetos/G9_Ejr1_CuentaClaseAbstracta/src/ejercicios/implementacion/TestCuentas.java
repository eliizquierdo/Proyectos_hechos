/*
 * Guía de laboratorio 09 - Programación 3 - 2012
 * Ejercio 1: Clase abstracta Cuenta ahorra sus atributos a Ahorro y Chequera.
 */
package ejercicios.implementacion;

import ejercicios.clasesabstractas.Ahorro;
import ejercicios.clasesabstractas.Chequera;
import javax.swing.JOptionPane;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public class TestCuentas {

    public static void main(String[] args) {
        Chequera listaCheq[] = new Chequera[2];
        Ahorro listaAhor[] = new Ahorro[2];
        int cuenta, contCh = 0, contAh = 0;
        
        JOptionPane.showMessageDialog(null, "Ingrese las cuentas chequeras");
        for(int i=0; i<listaCheq.length; i++) {
            cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la "
                    + "cuenta"));
            Chequera cheq = new Chequera(cuenta);
            listaCheq[contCh] = cheq;
            listaCheq[contCh].setSaldo(8.75);
            contCh++;
        }

        JOptionPane.showMessageDialog(null, "Ingrese las cuentas de ahorro");
        for(int i=0; i<listaAhor.length; i++) {
            cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la "
                    + "cuenta"));
            Ahorro ahor = new Ahorro(cuenta, 0.01);
            listaAhor[contAh] = ahor;
            listaAhor[contAh].setSaldo(10.0);
            contAh++;
        }
        
        String cCheq = "Las cuentas chequeras ingresadas son:\n";
        String cAhor = "Las cuentas de ahorro ingresadas son:\n";
        
        for(int i=0; i<listaCheq.length; i++) {
            cCheq += "Numero de cuenta: " + listaCheq[i].getNumeroCuenta() +
                    "\nSaldo: " + listaCheq[i].getSaldo() + "\nTipo de cuenta: " 
                    + listaCheq[i].getTipoCuenta() + "\n\n";
        }
        
        for(int i=0; i<listaAhor.length; i++) {
            cAhor += "Numero de cuenta: " + listaAhor[i].getNumeroCuenta() +
                    "\nSaldo: " + listaAhor[i].getSaldo() + "\nTipo de cuenta: " 
                    + listaAhor[i].getTipoCuenta() + "\nTasa de interes: " + 
                    listaAhor[i].getTasaInteres() + "\n\n";
        }
        
        JOptionPane.showMessageDialog(null, cCheq);
        JOptionPane.showMessageDialog(null, cAhor);
    }
}