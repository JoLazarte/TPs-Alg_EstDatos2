package org.uade.impl;

import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDAImpl implements ColaPrioridadTDA {
    private static class Nodo{
        public int num;
        public Nodo siguiente = null;
        public int prioridad;

        public Nodo(int num, int prioridad) {
            this.num = num;
            this.prioridad = prioridad;
        }
    }
    private Nodo cabeza;
    private Nodo ultimo;

    @Override
    public void inicializarCola() {
        ColaPrioridadTDA colaPriImpl = new ColaPrioridadTDAImpl ();
    }

    @Override
    public void acolarPrioridad(int x, int p) {
       Nodo nuevo = new Nodo(x, p);
       Nodo comienzo = cabeza; //podría ir dentro del segundo else
        if(cabeza==null){
            cabeza=nuevo;
        } else {
            //La PRIORIDAD de la cabeza es menor a la del nuevo nodo. => el nuevo nodo va antes y  la cabeza tiene un valor nuevo.
            if (cabeza.prioridad < p) {
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
            } else {
                // La PRIORIDAD de la cabeza es mayor a la del nuevo nodo. =>  Recorremos la cola comparando las prioridades de
                // los elementos para encontrar la posición adecuada del nuevo nodo.
                while (comienzo.siguiente != null && comienzo.siguiente.prioridad >= p) {
                    comienzo = comienzo.siguiente;
                }
                nuevo.siguiente = comienzo.siguiente;
                comienzo.siguiente = nuevo;
            }
        } ultimo = nuevo;
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

    @Override
    public int prioridad() {
        if(cabeza==null){
            return  0;
        } else {
            return cabeza.prioridad;
        }
    }
}
