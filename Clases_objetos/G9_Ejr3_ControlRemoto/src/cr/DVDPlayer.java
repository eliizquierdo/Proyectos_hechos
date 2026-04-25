package cr;

/**
 * @date 06/07/2018
 * @author Fredy Kcrez
 */
public class DVDPlayer implements ControlRemoto {
    private String marca = null;
    private boolean encendido = true;
    private final int VOLUMEN_MIN = 0;
    private final int VOLUMEN_MAX = 100;
    private int volumen = VOLUMEN_MIN;
    private final int CANAL_MINIMO = 0;
    private final int CANAL_MAXIMO = 999;
    private int canal = CANAL_MINIMO;

    public DVDPlayer(String marca) {
        this.marca = marca;
    }
    
    @Override
    public boolean encendido() {
        encendido = !encendido;
        System.out.println(marca + " " + (encendido ? "encendido." : 
                "apagado."));
        return encendido;
    }

    @Override
    public int subirVolumen(int incremento) {
        if(!encendido)
            return 0;
        volumen += incremento;
        volumen = Math.min(volumen, VOLUMEN_MAX);
        System.out.println(marca + " nivel de volumen: " + volumen);
        return volumen;
    }

    @Override
    public int bajarVolumen(int decremento) {
        if(!encendido)
            return 0;
        volumen -= decremento;
        volumen = Math.max(volumen, VOLUMEN_MIN);
        System.out.println(marca + " nivel de volumen: " + volumen);
        return volumen;
    }

    @Override
    public void ponerMudo() {
        if(!encendido)
            return;
        volumen = VOLUMEN_MIN;
        System.out.println(marca + " nivel de volumen: " + volumen);
    }

    @Override
    public int cambiarAlCanal(int canal) {                                      // canal: el nuevo canal al que se cambiará
        if(!encendido)
            return 0;
        if(canal >= CANAL_MINIMO && canal <=CANAL_MAXIMO)
            this.canal = canal;
        System.out.println(marca + " cambiado al canal: " + canal);
        return canal;
    }

    @Override
    public int canalAdelante(int canal) {
        if(!encendido)
            return 0;
        this.canal = canal < CANAL_MAXIMO ? ++canal : CANAL_MINIMO;
        System.out.println(marca + " cambiado al canal: " + canal);
        return this.canal;
    }

    @Override
    public int canalAtras(int canal) {
        if(!encendido)
            return 0;
        this.canal = canal > CANAL_MINIMO ? --canal : CANAL_MAXIMO;
        System.out.println(marca + " cambiado al canal: " + canal);
        return this.canal;
    }

    @Override
    public boolean getEncendido() {
        return this.encendido;
    }

    @Override
    public int getCanal() {
        return this.canal;
    }
}