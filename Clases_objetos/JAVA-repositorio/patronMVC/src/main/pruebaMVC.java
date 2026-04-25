/*
 * En esta aplicación se pone en practica el patrón MVC
 */
package main;

import controlador.Controlador;
import modelo.Modelo;
import vista.VistaInterfaz;

/**
 * @date 09/08/2018
 * @author Fredy Kcrez
 */
public class pruebaMVC {

    public static void main(String[] args) {
        Modelo mod = new Modelo();
        VistaInterfaz view = new VistaInterfaz();
        Controlador ctrl = new Controlador(view, mod);
        
        ctrl.iniciar();
        view.setVisible(true);
    }    
}