package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import java.util.Random;

public class ConjuntoTDAImpl implements ConjuntoTDA {
    private static class Nodo{
        public int num;
        public Nodo siguiente = null;

        public Nodo(int num) {
            this.num = num;
        }
    }

    private Nodo inicio;
    private int count;

    @Override
    public void inicializarConjunto() {
        inicio = null;
        count = 0;
    }

    @Override
    public void agregar(int x) {
        Nodo nuevo = new Nodo(x);
        if(inicio == null){ //this.conjuntoVacio()
            inicio = nuevo;
            count++;
        }
        if(pertenece(x)){ //uniqueness of the elements
            nuevo = null;
        }
        Nodo current = inicio; //insert at the end of the set
        while(current.siguiente != null){
            current = current.siguiente;
        }
        current.siguiente = nuevo;
        count++;
    }

    @Override
    public int elegir() {
        int elegido = 0;
        int max ;

        if(inicio != null) {
            Nodo current = inicio;
            int [ ] valores = new int [count];
            int x = 1;
            while(current != null){
                valores[x] = current.num;
                x++;
                current = current.siguiente;
            }
            max = encontrarMaximo(valores, 0, valores.length-1);
            while(!this.pertenece(elegido)){
                Random aleatorio = new Random();
                elegido = aleatorio.nextInt(max) + 1;
            }
        }
        return elegido;
    }

    @Override
    public void sacar(int x) {
        if(inicio != null) {
            if(inicio.num == x) {
                inicio = inicio.siguiente;
                count--;
            }
            Nodo current = inicio; //x is somewhere btw the set
            Nodo anterior = null;
            while(current != null ){
                if(current.num == x && anterior != null){ //find the node
                    anterior.siguiente = current.siguiente; //previous' next  becomes current's next
                    count--;
                }
                anterior = current; //update pointers
                current = current.siguiente;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        if (inicio != null) { //this.conjuntoVacio()
            Nodo current = inicio;
        //move till the end of the set
            while (current != null) {
                if (current.num == x) {
                    return true;
                }
                current = current.siguiente;
            }
         }//value not found:
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return inicio == null;
    }

    private static int encontrarMaximo(int[] arreglo, int inicio, int fin) {
        // Caso base: si el rango tiene un solo elemento
        if (inicio == fin) {
            return arreglo[inicio];
        }
        // Dividir el arreglo en dos mitades
        int medio = (inicio + fin) / 2;
        // Encontrar el máximo en la primera mitad
        int maxPrimeraMitad = encontrarMaximo(arreglo, inicio, medio);
        // Encontrar el máximo en la segunda mitad
        int maxSegundaMitad = encontrarMaximo(arreglo, medio + 1, fin);
        // Retornar el mayor de los dos máximos encontrados
        return Math.max(maxPrimeraMitad, maxSegundaMitad);
    }
}
