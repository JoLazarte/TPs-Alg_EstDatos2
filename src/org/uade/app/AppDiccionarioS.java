package org.uade.app;
import org.uade.api.ColaTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaTDAImpl;
import org.uade.impl.DiccionarioSimTDAImpl;
import org.uade.impl.PilaTDAImpl;
import org.uade.util.OperacionesCola;

public class AppDiccionarioS {

    private ColaTDA colaDatos;
    private PilaTDA pilaDatos;
    private DiccionarioSimpleTDA diccionarioDatos;
    private int contadorDatos;

    public AppDiccionarioS() {
        this.colaDatos = new ColaTDAImpl();
        this.pilaDatos = new PilaTDAImpl();
        this.diccionarioDatos = new DiccionarioSimTDAImpl();
        this.contadorDatos = 0; // Genera un identificador único para cada dato

        this.colaDatos.inicializarCola();
        this.pilaDatos.inicializarPila();
        this.diccionarioDatos.inicializarDiccionario();
    }


    public static void main(String[] args) {
        AppDiccionarioS app = new AppDiccionarioS();
        app.execute();
    }

    public void execute() {
        agregarDato("Guardar", "Archivo 1");
        agregarDato("Imprimir", "Archivo 2");
        agregarDato("Borrar", "Archivo 3");

        mostrarAlmacen();

        obtenerDatoMasAntiguo();
        obtenerDatoMasReciente();
    }


    // Metodo para agregar un dato al almacén
    public void agregarDato(String dato, String detalles) {
        contadorDatos++;
        // Acolamos el identificador único en la cola y apilamos en la pila
        colaDatos.acolar(contadorDatos);
        pilaDatos.apilar(contadorDatos);

        // Guardamos los detalles en el diccionario usando el identificador del dato
        diccionarioDatos.agregar(contadorDatos, detalles.hashCode()); // Usamos el hash del detalle como ejemplo

        System.out.println("Dato agregado: " + dato + " - Detalles: " + detalles);
    }

    // Metodo para obtener el dato más antiguo (FIFO)
    public void obtenerDatoMasAntiguo() {
        if (!colaDatos.colaVacia()) {
            int datoId = colaDatos.primero();
            colaDatos.desacolar();
            String detalles = obtenerDetallesDato(datoId);
            System.out.println("Dato más antiguo procesado: " + detalles);
        } else {
            System.out.println("No hay datos disponibles.");
        }
    }

    // Metodo para obtener el dato más reciente (LIFO)
    public void obtenerDatoMasReciente() {
        if (!pilaDatos.pilaVacia()) {
            int datoId = pilaDatos.tope();
            pilaDatos.desapilar();
            String detalles = obtenerDetallesDato(datoId);
            System.out.println("Dato más reciente procesado: " + detalles);
        } else {
            System.out.println("No hay datos disponibles.");
        }
    }

    // Metodo auxiliar para obtener los detalles de un dato desde el diccionario
    private String obtenerDetallesDato(int datoId) {
        int detallesHash = diccionarioDatos.recuperar(datoId);
        return String.valueOf(detallesHash); // Convertimos el hash de los detalles a String (ejemplo básico)
    }

    // Metodo para mostrar todos los datos del almacén (sin modificar el estado)
    public void mostrarAlmacen() {
        OperacionesCola operacionCola = new OperacionesCola();
        ColaTDA colaAuxiliar = operacionCola.copiarCola(colaDatos);
        System.out.println("Datos en el almacén (FIFO):");
        while (!colaAuxiliar.colaVacia()) {
            int datoId = colaAuxiliar.primero();
            String detalles = obtenerDetallesDato(datoId);
            System.out.println("Dato: " + detalles);
            colaAuxiliar.desacolar();
        }
    }
}
