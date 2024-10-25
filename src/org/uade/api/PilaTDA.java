package org.uade.api;

import org.uade.impl.PilaTDAImpl;

public interface PilaTDA {
    void inicializarPila();
    void apilar(int x);
    void desapilar();
    int tope();
    boolean pilaVacia();

}
