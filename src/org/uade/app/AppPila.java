package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;

public class AppPila {
    public static void main(String[] args) {
        PilaTDA pilaA= new PilaTDAImpl();
        pilaA.inicializarPila();
    }
}
