package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;
import org.uade.util.OperacionesPila;

public class AppPila {
    public static void main(String[] args) {
        PilaTDA pilaA= new PilaTDAImpl();
        pilaA.inicializarPila();
        pilaA.apilar(2);
        pilaA.apilar(3);
        pilaA.apilar(2);

        OperacionesPila opPila = new OperacionesPila();
        opPila.llenarPila(pilaA);
        opPila.mostrarPila(pilaA);
    }
}
