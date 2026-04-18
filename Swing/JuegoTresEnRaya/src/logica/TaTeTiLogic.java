package logica;

public class TaTeTiLogic {
    private String[][] posiciones = new String[3][3];
    private int contador = 0;
    private boolean hayJuego = true;

    public TaTeTiLogic() {
        // Inicializamos el tablero vacío
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                posiciones[i][j] = ""; // Tablero vacío
            }
        }
    }

    public String[][] getPosiciones() {
        return posiciones;
    }

    public int getContador() {
        return contador;
    }

    public boolean hayJuego() {
        return hayJuego;
    }

    public String realizarJugada(int x, int y) {
        // Comprobamos si la casilla está vacía
        if (posiciones[x][y].equals("")) {
            String jugador = (contador % 2 == 0) ? "X" : "O";
            posiciones[x][y] = jugador;
            contador++;
            return jugador;
        }
        return ""; // La casilla ya está ocupada
    }

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

    public boolean esEmpate() {
        return contador >= 9;
    }

    public void deshabilitarJuego() {
        hayJuego = false;
    }
}

