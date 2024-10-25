package org.uade.util;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaTDAImpl;

import java.util.Scanner;

public class OperacionesPila {
    public void  mostrarPila(PilaTDA pila){
        while (!pila.pilaVacia()) { //while pila is not empty....
            System.out.println(pila.tope());  //show me the top and....
            pila.desapilar(); //take that top out.
        }
    }
    public void llenarPila(PilaTDA pila, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la pila " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la pila " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            pila.apilar(elemento);
        }
    }
}
