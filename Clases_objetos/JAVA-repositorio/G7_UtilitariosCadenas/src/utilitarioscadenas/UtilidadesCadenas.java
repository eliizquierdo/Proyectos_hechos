package utilitarioscadenas;

/**
 * @date 27/06/2018
 * @author Fredy Kcrez
 */
public class UtilidadesCadenas {
    private String cad;

    public static String[] palabrasInversas(String cadena) {
        String [] cad = cadena.split(" ");
        int x = cad.length;
        String [] tmp = new String[x];

        for(int i=0; i<cad.length; i++) {
            x--;
            tmp[i] = cad[x];
        }
        return tmp;
    }
    
    public static String inicioMayusculas(String cadena) {
        return cadena.substring(0, 1).toUpperCase() + cadena.substring(1);
    }
    
    public static String inicioTodasMayusculas(String cadena) {
        String [] cad = cadena.split(" ");
        cadena = "";
        for(int i=0; i<cad.length; i++) {
            cadena += cad[i].substring(0, 1).toUpperCase() + cad[i].substring(1) + " ";
        }
        return cadena;
    }
}