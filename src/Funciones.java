public class Funciones {
        public static int ProductoMaximoSubArreglo(int[] numeros) {

            if (numeros == null || numeros.length == 0) {
                return 0;
            }

            int numeroMaximo = numeros[0];
            int numeroMinimo= numeros[0];
            int resultado = numeros[0];

            for (int i = 1; i < numeros.length; i++) {
                int numeroActual = numeros[i];

                if (numeroActual < 0) {
                    int numTemporal = numeroMaximo;
                    numeroMaximo = numeroMinimo;
                    numeroMinimo = numTemporal;
                }

                numeroMaximo = Math.max(numeroActual, numeroMaximo * numeroActual);
                numeroMinimo = Math.min(numeroActual, numeroMinimo * numeroActual);

                resultado = Math.max(resultado, numeroMaximo);
            }

            return resultado;
        }
        public static int AguaAlmacenada(int[] columnas){

            int resultado = 0;
            int valorAnterior = 0;
            int valorAnteriorMax = 0;
            int valorProximo = columnas.length -1;
            int valorProximoMaximo = 0;

            while(valorAnterior < valorProximo) {
                if (columnas[valorAnterior] < columnas[valorProximo]){
                    if (columnas[valorAnterior] >= valorAnteriorMax) {
                        valorAnteriorMax = columnas[valorAnterior];
                    } else {
                        resultado += valorAnteriorMax - columnas[valorAnterior];
                    }
                    valorAnterior++;
                }else{
                    if (columnas[valorProximo] >= valorProximoMaximo){
                        valorProximoMaximo = columnas[valorProximo];
                    }else{
                        resultado += valorProximoMaximo - columnas[valorProximo];
                    }
                    valorProximo--;
                }
            }
            return resultado;
        }
    public static int CostoMinimo(int[][] costos) {
        if (costos == null || costos.length == 0 || costos[0].length == 0) {
            return 0;
        }

        int m = costos.length;
        int n = costos[0].length;

        int[][] costo = new int[m][n];

        costo[0][0] = costos[0][0];

        for (int j = 1; j < n; j++) {
            costo[0][j] = costo[0][j - 1] + costos[0][j];
        }

        for (int i = 1; i < m; i++) {
            costo[i][0] = costo[i - 1][0] + costos[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                costo[i][j] = Math.min(costo[i - 1][j], costo[i][j - 1]) + costos[i][j];
            }
        }

        return costo[m - 1][n - 1];
    }
    public static int ContarIslas(int[][] islas) {
        if (!IslaValida(islas)) {
            return 0;
        }

        int numIslas = 0;
        int filas = islas.length;
        int columnas = islas[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (islas[i][j] == 1) {
                    marcarIsla(islas, i, j);
                    numIslas++;
                }
            }
        }

        return numIslas;
    }
    public static Boolean IslaValida(int[][] islas){
        int filas = islas.length;
        int columnas = islas[0].length;

        if(islas == null || islas.length == 0){
            return false;
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (islas[i][j] != 1 && islas[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void marcarIsla(int[][] islas, int i, int j) {
        int filas = islas.length;
        int columnas = islas[0].length;

        if (i < 0 || i >= filas || j < 0 || j >= columnas || islas[i][j] != 1) {
            return;
        }

        islas[i][j] = -1; //

        marcarIsla(islas, i + 1, j); // abajo
        marcarIsla(islas, i - 1, j); // arriba
        marcarIsla(islas, i, j + 1); // derecha
        marcarIsla(islas, i, j - 1); // izquierda
        marcarIsla(islas, i + 1, j + 1); // diagonal inferior derecha
        marcarIsla(islas, i - 1, j - 1); // diagonal superior izquierda
        marcarIsla(islas, i + 1, j - 1); // diagonal inferior izquierda
        marcarIsla(islas, i - 1, j + 1); // diagonal superior derecha
    }

    public static void transformarMatriz(int[][] islas) {
        if (islas == null || islas.length == 0 || islas[0].length == 0) {
            return;
        }

        int m = islas.length;
        int n = islas[0].length;

        boolean[] filaCero = new boolean[m];
        boolean[] columnaCero = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (islas[i][j] == 0) {
                    filaCero[i] = true;
                    columnaCero[j] = true;
                }
            }
        }

        // Paso 2: Establecer filas a cero
        for (int i = 0; i < m; i++) {
            if (filaCero[i]) {
                for (int j = 0; j < n; j++) {
                    islas[i][j] = 0;
                }
            }
        }

        // Paso 3: Establecer columnas a cero
        for (int j = 0; j < n; j++) {
            if (columnaCero[j]) {
                for (int i = 0; i < m; i++) {
                    islas[i][j] = 0;
                }
            }
        }
    }
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

   public static void buscarCaminoLaberinto(int[][] laberinto){
       boolean[][] visited = new boolean[laberinto.length][laberinto[0].length];
       Laberinto lab = new Laberinto();
       int shortestPathLength = lab.buscarCaminoMasCorto(laberinto, visited, 0, 0, 0, Integer.MAX_VALUE);

       if (shortestPathLength == Integer.MAX_VALUE) {
           System.out.println("No hay camino disponible");
       } else {
           System.out.println("El camino más corto es de longitud: " + (shortestPathLength - 1));
       }
   }



}
