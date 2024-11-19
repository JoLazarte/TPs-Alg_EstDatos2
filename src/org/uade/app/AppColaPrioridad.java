package org.uade.app;
import org.uade.api.ColaPrioridadTDA;
import org.uade.impl.ColaPrioridadTDAImpl;
import org.uade.util.OperacionesColaPrioridad;

public class AppColaPrioridad {
    public static void main(String[] args) {
        AppColaPrioridad app = new AppColaPrioridad();
        app.execute();
    }
    public void execute() {
        ColaPrioridadTDA cola = new ColaPrioridadTDAImpl();
        cola.inicializarCola();

        // Ejemplo de carga de la pila
        cola.acolarPrioridad(3, 9);
        cola.acolarPrioridad(10, 5);
        cola.acolarPrioridad(4, 1);
        cola.acolarPrioridad(2, 4);
        cola.acolarPrioridad(5, 5);
        cola.acolarPrioridad(12,9);
        cola.acolarPrioridad(0, 2);

        eliminarPorPrioridad(cola, 4);

        OperacionesColaPrioridad op = new OperacionesColaPrioridad();
        op.mostrar(cola);
    }

    private void eliminarPorPrioridad(ColaPrioridadTDA cola, int prioridadEliminar) {
        if (!cola.colaVacia()) {
            int elemento = cola.primero();
            int prioridad = cola.prioridad();
            cola.desacolar();

            eliminarPorPrioridad(cola, prioridadEliminar);

            // Volver a acolar solo si la prioridad no coincide con la que se quiere eliminar
            if (prioridad != prioridadEliminar) {
                cola.acolarPrioridad(elemento, prioridad);
            }
        }
    }
}
