package cr;

/**
 * @date 06/07/2018
 * @author Fredy Kcrez
 */
public interface ControlRemoto {
    public int getCanal();
    public boolean getEncendido();
    public boolean encendido();
    public int subirVolumen(int incremento);
    public int bajarVolumen(int decremento);
    public void ponerMudo();
    public int cambiarAlCanal(int canal);
    public int canalAdelante(int canal);
    public int canalAtras(int canal);
}