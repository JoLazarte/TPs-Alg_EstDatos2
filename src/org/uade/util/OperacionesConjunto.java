package org.uade.util;
import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoTDAImpl;
public class OperacionesConjunto {
    //22:13
    public void mostrarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA temp = new ConjuntoTDAImpl();
        temp.inicializarConjunto();

        // Copiamos los elementos del conjunto original al conjunto temporal
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.println(elemento); // Mostramos el elemento
            temp.agregar(elemento);
            conjunto.sacar(elemento);
        }

        // Restauramos el conjunto original
        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            conjunto.agregar(elemento);
            temp.sacar(elemento);
        }
    }
    public ConjuntoTDA copiarConjunto(ConjuntoTDA conjuntoOriginal) {
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();

        ConjuntoTDA conjuntoTemp = new ConjuntoTDAImpl(); // Temporal para iterar sin modificar el original
        conjuntoTemp.inicializarConjunto();

        while (!conjuntoOriginal.conjuntoVacio()) {
            int elemento = conjuntoOriginal.elegir();
            conjuntoOriginal.sacar(elemento);
            copia.agregar(elemento);
            conjuntoTemp.agregar(elemento);
        }

        while (!conjuntoTemp.conjuntoVacio()) {
            int elemento = conjuntoTemp.elegir();
            conjuntoTemp.sacar(elemento);
            conjuntoOriginal.agregar(elemento);
        }

        return copia;
    }
}
