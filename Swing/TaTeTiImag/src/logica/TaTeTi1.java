package logica;

public class TaTeTi1 {
    private String[][] posiciones = new String[3][3];
    private int contador = 0;

    public TaTeTi1() {
        // Inicialización del tablero con valores vacíos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                posiciones[i][j] = "";
            }
        }
    }

    public String[][] getPosiciones() {
        return posiciones;
    }

    public int getContador() {
        return contador;
    }

    // Realizar una jugada
    public String realizarJugada(int x, int y) {
        if (posiciones[x][y].equals("")) {
            String jugador = (contador % 2 == 0) ? "X" : "O";
            posiciones[x][y] = jugador;
            contador++;
            return jugador;
        }
        return ""; // Casilla ocupada, no se hace la jugada
    }

    // Verificar si hay una victoria
    public boolean esVictoriaRecta() {
        // Verificar filas
        for (int x = 0; x < 3; x++) {
            if (!posiciones[x][0].equals("") && posiciones[x][0].equals(posiciones[x][1]) && posiciones[x][0].equals(posiciones[x][2])) {
                return true;
            }
        }
        // Verificar columnas
        for (int x = 0; x < 3; x++) {
            if (!posiciones[0][x].equals("") && posiciones[0][x].equals(posiciones[1][x]) && posiciones[0][x].equals(posiciones[2][x])) {
                return true;
            }
        }
        // Verificar diagonales
        if (!posiciones[0][0].equals("") && posiciones[0][0].equals(posiciones[1][1]) && posiciones[0][0].equals(posiciones[2][2])) {
            return true;
        }
        if (!posiciones[0][2].equals("") && posiciones[0][2].equals(posiciones[1][1]) && posiciones[0][2].equals(posiciones[2][0])) {
            return true;
        }
        return false;
    }

    // Verificar si el juego ha terminado en empate
    public boolean esEmpate() {
        return contador >= 9;
    }

    public void deshabilitarJuego() {
        // Puedes agregar lógica para deshabilitar cualquier interacción si el juego termina
    }
}
