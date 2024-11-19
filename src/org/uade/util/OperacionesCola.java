package org.uade.util;
import org.uade.api.ColaTDA;
import java.util.Scanner;
public class OperacionesCola {
    Scanner sc = new Scanner(System.in);
    public void mostrar(ColaTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }
    public void llenar(ColaTDA cola) {
        System.out.println("Ingrese la cantidad de elementos para la cola: ");
        int n = sc.nextInt();

        System.out.println("Ingrese los elementos de la cola: ");
        for (int i = 0; i < n; i++) {
            int elemento = sc.nextInt();
            cola.acolar(elemento);
        }
    }
}
