import java.util.PriorityQueue;

public class Lista {

    private NodoLista inicio;

    public Lista() {
        this.inicio = null;
    }

    public void insertarInicio(int x) {
        NodoLista nuevo = new NodoLista(x);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;
    }

    public static NodoLista combinarListas(NodoLista[] listas){
        PriorityQueue<NodoLista> minHeap = new PriorityQueue<>((a, b) -> a.valor - b.valor);

        for(NodoLista nodo : listas){
            if(nodo != null){
                minHeap.offer(nodo);
            }
        }

        NodoLista nodoTemporal = new NodoLista(-1);
        NodoLista actual = nodoTemporal;

        while(!minHeap.isEmpty()){
            NodoLista menorValor = minHeap.poll();
            actual.proximo = menorValor;
            actual = actual.proximo;

            if(menorValor.proximo != null){
                minHeap.offer(menorValor.proximo);
            }
        }
        return nodoTemporal.proximo;
    }

    public static void imprimirLista(NodoLista cabeza){

        NodoLista actual = cabeza;

        while(actual != null){
            System.out.println(actual.valor + " ");
            actual = actual.proximo;
        }

        System.out.println();
    }
    public static NodoLista sumaInvertida(NodoLista listaA, NodoLista listaB){

        NodoLista listaTemporal = new NodoLista(0);
        NodoLista actual = listaTemporal;
        int cargar = 0;

        while(listaA != null || listaB != null){

            int valorA = (listaA != null) ? listaA.valor : 0;
            int valorB = (listaB != null) ? listaB.valor : 0;
            int suma = valorA + valorB + cargar;
            cargar = suma / 10;
            int digito = suma % 10;
            actual.proximo = new NodoLista(digito);
            actual = actual.proximo;

            if(listaA != null) listaA = listaA.proximo;
            if(listaB != null) listaB = listaB.proximo;
        }

        if(cargar > 0){
            actual.proximo = new NodoLista(cargar);
        }

        return listaTemporal.proximo;
    }

    public static NodoLista invertirLista(NodoLista cabeza) {

        if (cabeza == null || cabeza.proximo == null) {
            return cabeza;
        }

        NodoLista nuevaCabeza = invertirLista(cabeza.proximo);
        cabeza.proximo.proximo = cabeza;
        cabeza.proximo = null;

        return nuevaCabeza;
    }

}
