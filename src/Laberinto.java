public class Laberinto {
    private static final int[] dFila = {-1, 1, 0, 0};
    private static final int[] dColumna = {0, 0, -1, 1};


    public static int buscarCaminoMasCorto(int[][] laberinto, boolean[][] visitado, int fila, int columna, int distancia, int distanciaMin) {
        int filas = laberinto.length;
        int colas = laberinto[0].length;

        // Si hemos llegado a la esquina inferior derecha
        if (fila == filas - 1 && columna == colas - 1) {
            return Math.min(distancia, distanciaMin);
        }

        // Marcar la celda actual como visitada
        visitado[fila][columna] = true;

        // Explorar las cuatro direcciones
        for (int i = 0; i < 4; i++) {
            int newRow = fila + dFila[i];
            int newCol = columna + dColumna[i];

            if (esValido(laberinto, visitado, newRow, newCol)) {
                distanciaMin = buscarCaminoMasCorto(laberinto, visitado, newRow, newCol, distancia + 1, distanciaMin);
            }
        }

        // Desmarcar la celda actual para permitir otras exploraciones
        visitado[fila][columna] = false;

        return distanciaMin;
    }

    private static boolean esValido(int[][] laberinto, boolean[][] visitado, int fila, int columna) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;
        return (fila >= 0 && fila < filas && columna >= 0 && columna < columnas && laberinto[fila][columna] == 1 && !visitado[fila][columna]);
    }
}
