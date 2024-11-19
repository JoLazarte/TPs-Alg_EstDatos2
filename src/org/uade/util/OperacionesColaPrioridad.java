package org.uade.util;
import org.uade.api.ColaPrioridadTDA;
import java.util.Scanner;

public class OperacionesColaPrioridad extends OperacionesCola{
    Scanner scCP = new Scanner(System.in);
    public void mostrar(ColaPrioridadTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }
    public void llenar(ColaPrioridadTDA cola) {
        System.out.println("Ingrese la cantidad de elementos para la cola: ");
        int n = scCP.nextInt();

        System.out.println("Ingrese los elementos de la cola: ");
        for (int i = 0; i < n; i++) {
            int elemento = scCP.nextInt();
            int prioridad = 0;
            cola.acolarPrioridad(elemento, prioridad);
        }
    }
}
