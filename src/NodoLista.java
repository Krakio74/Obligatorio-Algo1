public class NodoLista {
        int valor;
        NodoLista proximo;

        public NodoLista(int x){this.valor = x;}

        public int getElemeneto() {
                return valor;
        }

        public void setElemeneto(int elemeneto) {
                this.valor = elemeneto;
        }

        public NodoLista getSiguiente() {
                return proximo;
        }

        public void setSiguiente(NodoLista siguiente) {
                this.proximo = siguiente;
        }

}
