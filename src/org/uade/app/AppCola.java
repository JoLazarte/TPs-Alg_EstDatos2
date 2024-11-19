package org.uade.app;
import org.uade.api.ColaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.util.OperacionesCola;

public class AppCola {
    public static void main(String[] args) {
        AppCola app = new AppCola();
        app.execute();
    }

    public void execute() {
        ColaTDA colaA = new ColaTDAImpl();
        ColaTDA colaB = new ColaTDAImpl();
        colaA.inicializarCola();
        colaB.inicializarCola();

        OperacionesCola operacion = new OperacionesCola();
        operacion.llenar(colaA);
        operacion.llenar(colaB);

        // Intercalamos las colas
        ColaTDA colaC = intercalarColas(colaA, colaB);
        operacion.mostrar(colaC);
    }

    private ColaTDA intercalarColas(ColaTDA colaA, ColaTDA colaB) {
        ColaTDA colaC = new ColaTDAImpl();
        colaC.inicializarCola();

        // Mientras alguna de las colas A o B no esté vacía
        while (!colaA.colaVacia() || !colaB.colaVacia()) {
            if (!colaA.colaVacia()) {
                colaC.acolar(colaA.primero());
                colaA.desacolar();
            }
            if (!colaB.colaVacia()) {
                colaC.acolar(colaB.primero());
                colaB.desacolar();
            }
        }
        return colaC;
    }
}
