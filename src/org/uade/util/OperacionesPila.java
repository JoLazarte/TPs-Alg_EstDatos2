package org.uade.util;

import org.uade.api.PilaTDA;

import java.util.Scanner;

public class OperacionesPila {
    Scanner sc = new Scanner(System.in);
    public void  mostrarPila(PilaTDA pila){
        while (!pila.pilaVacia()) { //while pila is not empty....
            System.out.println(pila.tope());  //show me the top and....
            pila.desapilar(); //take that top out.
        }

    }
    public void llenarPila(PilaTDA pila) {
        System.out.println("Ingrese la cantidad de elementos para la pila: ");
        int n = sc.nextInt();

        System.out.println("Ingrese los elementos de la pila : ");
        for (int i = 0; i < n; i++) {
            int elemento = sc.nextInt();
            pila.apilar(elemento);
        }
    }
}
