package org.uade.app;
import org.uade.api.ABBTDA;
import org.uade.impl.ABBTDAImpl;
import org.uade.util.OperacionesArbol;
/*
Dado dos arboles binarios, se quiere comprobar si ambos tienen la misma estructura.
Considerandos:
- No es necesario comprobar si tienen los mismos valores.
 */
public class AppABB {

    public static void main(String[] args) {
       AppABB app = new AppABB();
        app.execute();
    }

    public void execute() {
        ABBTDA arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        // Agregamos nodos al árbol
        arbol.agregar(10);
        arbol.agregar(5);
        arbol.agregar(20);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(15);
        arbol.agregar(30);

        // Queremos extraer el subárbol con la raíz en el valor 5
        ABBTDA nuevoArbol = extraerSubarbol(5, arbol);

        OperacionesArbol operacion = new OperacionesArbol();
        operacion.mostrarArbolInorden(nuevoArbol);
    }


    // Metodo que busca un valor en el árbol y construye un nuevo árbol con ese valor y su subárbol
    public ABBTDA extraerSubarbol(int valor, ABBTDA arbolOriginal) {
        // Inicializamos un nuevo árbol para almacenar el subárbol
        ABBTDA nuevoArbol = new ABBTDAImpl();
        nuevoArbol.inicializarArbol();

        // Buscamos el valor en el árbol original
        if (buscarYExtraer(arbolOriginal, nuevoArbol, valor)) {
            // Si encontramos el nodo, eliminamos el subárbol del árbol original
            eliminarSubarbol(arbolOriginal, valor);

        }
        System.out.println("Se eliminó ! ! !");
        return nuevoArbol;
    }

    // Metodo recursivo para buscar el nodo con el valor dado y copiar su subárbol
    private boolean buscarYExtraer(ABBTDA origen, ABBTDA destino, int valor) {
        if (origen.arbolVacio()) {
            return false;  // No se encontró el valor
        }

        if (origen.raiz() == valor) {
            copiarArbol(origen, destino);
            // Copiamos  to do el sub arbol
            return true;  // Se encontró el valor
        }

        // Buscamos recursivamente en el subárbol izquierdo y derecho
        return buscarYExtraer(origen.hijoIzq(), destino, valor) || buscarYExtraer(origen.hijoDer(), destino, valor);
    }

    // Metodo para copiar el contenido de un árbol a otro
    private void copiarArbol(ABBTDA origen, ABBTDA destino) {
        if (!origen.arbolVacio()) {
            destino.agregar(origen.raiz());  // Copiamos la raíz
            copiarArbol(origen.hijoIzq(), destino);  // Copiamos el subárbol izquierdo
            copiarArbol(origen.hijoDer(), destino);  // Copiamos el subárbol derecho
        }
    }

    // Metodo para eliminar el subárbol con la raíz igual al valor dado
    private void eliminarSubarbol(ABBTDA arbol, int valor) {
        if (!arbol.arbolVacio()) {
            if (arbol.raiz() == valor) {
                arbol.eliminar(valor);

                // Eliminamos el nodo raíz y su subárbol
            } else {
                eliminarSubarbol(arbol.hijoIzq(), valor);
                eliminarSubarbol(arbol.hijoDer(), valor);

            }
        }
    }


}