package org.uade.impl;

import org.uade.api.PilaTDA;

public class PilaTDAImpl implements PilaTDA {

    private static class Nodo{
        public int num;
        public Nodo siguiente = null;

        public Nodo(int num) {
            this.num = num;
        }
    }
    private Nodo inicio = null;
    private int longitud = 0;

    @Override
    public void inicializarPila() {
        PilaTDA pilaImpl = new PilaTDAImpl();
    }

    @Override
    public void apilar(int x) {
        Nodo nuevo = new Nodo(x);
        //agrego el valor al  nuevo nodo
        nuevo.siguiente = inicio;
        inicio = nuevo;
        longitud++;
    }

    @Override
    public void desapilar() {
        if(inicio != null){
            Nodo eliminar = inicio;
            //asigno como primer nodo al siguiente de la  pila
            inicio = inicio.siguiente;
            eliminar.siguiente = null;
            longitud--;  //Decrementa el contador de la longitud de la pila
        }
    }

    @Override
    public int tope() {
        if(inicio==null){
            System.out.println("La pila se encuentra vacia.");
            return 0;
        } else{
            return inicio.num;
        }
    }

    @Override
    public boolean pilaVacia() {
        return inicio == null;
    }

}
