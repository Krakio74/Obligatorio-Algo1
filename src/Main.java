
public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        int[] arreglo = {1, -5 , 3, 5};
        System.out.println("El producto máximo del subarreglo es: " + Funciones.ProductoMaximoSubArreglo(arreglo));

        //Ejercicio 2
        int[] columnas = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("El agua almacenada es: " + Funciones.AguaAlmacenada(columnas));

        //Ejecrcicio 3
        int[][] costos = {{1,2,3}, {5,4,3}, {7,6,5}};//{{1, 3, 1},{1, 5, 1}, {4, 2, 1}};
        System.out.println("El costo minimo es: " + Funciones.CostoMinimo(costos));

        //Ejercicio4
        int[][] islas = {
                {0,0,0,1,1,0,0,0,1,0},
                {0,0,1,0,1,0,0,0,1,1},
                {0,1,0,0,1,1,1,0,0,0},
                {0,1,0,0,0,0,0,1,0,0},
                {0,0,1,0,1,0,1,0,0,1},
                {0,0,1,0,0,0,1,0,0,1},
                {0,0,0,1,1,1,0,0,1,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0},
                {0,0,1,1,0,0,1,0,1,0},
                {0,0,0,0,0,0,0,0,0,1}

        };
        int[][] islas2 = {
                {0,1,1,2},
                {1,0,0,0},
                {0,0,0,1}
        };
        System.out.println("Número de islas: " + Funciones.ContarIslas(islas2));

        //Ejercicio 5
        int[][] matriz = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        Funciones.transformarMatriz(matriz);

        System.out.println("\nMatriz transformada:");
        Funciones.imprimirMatriz(matriz);

        //Ejercicio 6
        NodoLista listaA = new NodoLista(1);
        listaA.proximo = new NodoLista(4);
        listaA.proximo.proximo = new NodoLista(5);

        NodoLista listaB = new NodoLista(1);
        listaB.proximo = new NodoLista(3);
        listaB.proximo.proximo = new NodoLista(4);

        NodoLista listaC = new NodoLista(2);
        listaC.proximo = new NodoLista(6);

        NodoLista[] listas = {listaA, listaB, listaC};

         NodoLista combinarListas = Lista.combinarListas(listas);
         Lista.imprimirLista(combinarListas);

         //Ejemplo: Para las listas [2, 4, 3] y [5, 6, 4], la lista resultada es [7, 0, 8] (342 + 465 =
        //807).
        NodoLista listaSumaA = new NodoLista(2);
        listaSumaA.proximo = new NodoLista(4);
        listaSumaA.proximo.proximo = new NodoLista(3);

        NodoLista listaSumaB = new NodoLista(5);
        listaSumaB.proximo = new NodoLista(6);
        listaSumaB.proximo.proximo = new NodoLista(4);

        NodoLista sumaInvertida = Lista.sumaInvertida(listaSumaA, listaSumaB);
        Lista.imprimirLista(sumaInvertida);

        //Ejercicio 8
        NodoLista l1 = new NodoLista(1);
        l1.proximo = new NodoLista(2);
        l1.proximo.proximo = new NodoLista(3);
        l1.proximo.proximo.proximo = new NodoLista(4);
        l1.proximo.proximo.proximo.proximo = new NodoLista(5);

        System.out.println("Lista enlazada original:");
        Lista.imprimirLista(l1);

        // Invertir la lista enlazada recursivamente
        NodoLista listaInvertida = Lista.invertirLista(l1);

        System.out.println("\nLista enlazada invertida:");
        Lista.imprimirLista(listaInvertida);

        //Ejercicio 9
        int[][] laberinto = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 1}
        };
        Funciones.buscarCaminoLaberinto(laberinto);

        //Ejercicio 10
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        Mochila mochila = new Mochila();
        int maxValue = mochila.calcularMaximoValor(weights, values, capacity);
        System.out.println("El valor máximo que se puede obtener en la mochila es: " + maxValue);
    }

}