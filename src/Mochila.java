public class Mochila {
    public static int calcularMaximoValor(int[] peso, int[] valor, int capacidad) {
        int n = peso.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        // Construir la tabla dp de abajo hacia arriba
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (peso[i - 1] <= w) {
                    dp[i][w] = Math.max(valor[i - 1] + dp[i - 1][w - peso[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacidad];
    }
}
