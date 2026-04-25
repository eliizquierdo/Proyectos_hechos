/*
 * Guía de laboratorio 09 - Programación 3 - 2012
 * Ejercio 1 Interfaces: Implementación de interfaz ControlRemoto
 */
package cr;

import javax.swing.JOptionPane;

/**
 * @date 06/07/2018
 * @author Fredy Kcrez
 */
public class TestControlRemoto {

    public static void main(String[] args) {
        Tv tv;
        DVDPlayer dvd;
        String marca;
        int canal;
        
        int device = Integer.parseInt(JOptionPane.showInputDialog("Seleccione "
                + "el dispositivo a "
                + "utilizar:\n1. TV.\n2. DVD Player."));
        
        switch(device) {
            case 1:
                marca = JOptionPane.showInputDialog("Ingrese la marca de la "
                        + "TV");
                int tamanio = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese el tamaño de la pantalla"));
                tv = new Tv(marca, tamanio);
                do {
                    int option = Integer.parseInt(JOptionPane.showInputDialog(
                            "Que acción desea realizar:"
                                    + "\n1. Subir volumen"
                                    + "\n2. Bajar volumen"
                                    + "\n3. Poner mudo"
                                    + "\n4. Cambiar canal"
                                    + "\n5. Siguiente canal"
                                    + "\n6. Canal anterior"
                                    + "\n7. Apagar"));
                    switch(option) {
                        case 1:
                            tv.subirVolumen(5);
                            break;
                        case 2:
                            tv.bajarVolumen(5);
                            break;
                        case 3:
                            tv.ponerMudo();
                            break;
                        case 4:
                            canal = Integer.parseInt(JOptionPane.showInputDialog(
                                    "Ingrese el canal al que desea cambiar"));
                            tv.cambiarAlCanal(canal);
                            break;
                        case 5:
                            tv.canalAdelante(tv.getCanal());
                            break;
                        case 6:
                            tv.canalAtras(tv.getCanal());
                            break;
                        case 7:
                            tv.encendido();
                            break;
                        default:
                            tv.encendido();
                            break;
                    }
                } while(tv.getEncendido());
                break;
            case 2:
                marca = JOptionPane.showInputDialog("Ingrese la marca de la "
                        + "TV");
                dvd = new DVDPlayer(marca);
                do {
                    int option = Integer.parseInt(JOptionPane.showInputDialog(
                            "Que acción desea realizar:"
                                    + "\n1. Subir volumen"
                                    + "\n2. Bajar volumen"
                                    + "\n3. Poner mudo"
                                    + "\n4. Cambiar canal"
                                    + "\n5. Siguiente canal"
                                    + "\n6. Canal anterior"
                                    + "\n7. Apagar"));
                    switch(option) {
                        case 1:
                            dvd.subirVolumen(5);
                            break;
                        case 2:
                            dvd.bajarVolumen(5);
                            break;
                        case 3:
                            dvd.ponerMudo();
                            break;
                        case 4:
                            canal = Integer.parseInt(JOptionPane.showInputDialog(
                                    "Ingrese el canal al que desea cambiar"));
                            dvd.cambiarAlCanal(canal);
                            break;
                        case 5:
                            dvd.canalAdelante(dvd.getCanal());
                            break;
                        case 6:
                            dvd.canalAtras(dvd.getCanal());
                            break;
                        case 7:
                            dvd.encendido();
                            break;
                        default:
                            dvd.encendido();
                            break;
                    }
                } while(dvd.getEncendido());
                break;
            default:
                break;
        }
                
    }
}