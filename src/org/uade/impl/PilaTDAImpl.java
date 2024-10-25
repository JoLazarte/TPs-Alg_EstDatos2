package org.uade.impl;

import org.uade.api.PilaTDA;

import java.util.Scanner;

public class PilaTDAImpl implements PilaTDA {
    //definir estructuras de datos
    private PilaTDA pila;
    public void setPila(PilaTDA pila) {
        this.pila = pila;
    }
    public PilaTDA getPila() {
        return pila;
    }

    @Override
    public void inicializarPila() {
        pila.inicializarPila();
    }

    @Override
    public void apilar(int x) {
        pila.apilar(x);
    }

    @Override
    public void desapilar() {
        pila.desapilar();
    }

    @Override
    public int tope() {
        return 0;
    }

    @Override
    public boolean pilaVacia() {
        return false;
    }



}
