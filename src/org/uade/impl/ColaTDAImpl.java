package org.uade.impl;

import org.uade.api.ColaTDA;

public class ColaTDAImpl implements ColaTDA {

    private static class Nodo{
        public int num;
        public Nodo siguiente = null;

        public Nodo(int num) {
            this.num = num;
        }
    }
    private Nodo cabeza;
    private Nodo ultimo;

    @Override
    public void inicializarCola() {
        cabeza = null;
        ultimo = null;
    }

    @Override
    public void acolar(int x) {
        Nodo nuevo = new Nodo(x);
        //agrego el valor al  nuevo nodo
        if(cabeza==null){
            cabeza=nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
    }

    @Override
    public void desacolar() {
        if(cabeza != null){
            Nodo eliminar = cabeza;
            cabeza = cabeza.siguiente;
            eliminar.siguiente = null;
            if(cabeza == null){
                ultimo = null;
            }
        }
    }

    @Override
    public int primero() {
        if(cabeza==null){
            return  0;
        } else {
            return cabeza.num;
        }
    }

    @Override
    public boolean colaVacia() {
        return cabeza==null;
    }
}
