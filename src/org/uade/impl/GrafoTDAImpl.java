package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.GrafoTDA;

public class GrafoTDAImpl implements GrafoTDA {
    private static class Nodo {
        private int vertex;
        private int weight;
        private Nodo next;

        public Nodo(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = null;
        }
    }
    private Nodo[ ] adjacencyList;
    private int capacity;
    private ConjuntoTDA vertices;
    private static final int INITIAL_CAPACITY = 10;

    @Override
    public void inicializarGrafo() {
        capacity = INITIAL_CAPACITY;
        adjacencyList = new Nodo[capacity];
        vertices = new ConjuntoTDAImpl();
    }

    @Override
    public void agregarVertice(int vertice) {
        if (vertice < 0) throw new IllegalArgumentException("Vertex must be non-negative");
        // Expand array if needed
        if (vertice >= capacity) {
            int newCapacity = Math.max(capacity * 2, vertice + 1);
            Nodo[] newList = new Nodo[newCapacity];
            System.arraycopy(adjacencyList, 0, newList, 0, capacity);
            adjacencyList = newList;
            capacity = newCapacity;
        }

        vertices.agregar(vertice);
    }

    @Override
    public void eliminarVertice(int vertice) {
        if (vertice < 0 || vertice>= capacity)
            throw new IllegalArgumentException("Invalid vertex");

        // Remove all edges that point to this vertex
        for (int i = 0; i < capacity; i++) {
            if (adjacencyList[i] != null) {
                // Remove if it's the first node
                while (adjacencyList[i] != null && adjacencyList[i].vertex == vertice) {
                    adjacencyList[i] = adjacencyList[i].next;
                }
                // Remove from the rest of the list
                Nodo current = adjacencyList[i];
                while (current != null && current.next != null) {
                    if (current.next.vertex == vertice) {
                        current.next = current.next.next;
                    } else {
                        current = current.next;
                    }
                }
            }
        }
        // Remove all edges from this vertex
        adjacencyList[vertice] = null;
        vertices.sacar(vertice);
    }

    @Override
    public ConjuntoTDA vertices() {
        return vertices;
    }

    @Override
    public void agregarArista(int v1, int v2, int peso) {
        if (v1 < 0 || v1 >= capacity || v2 < 0 || v2 >= capacity)
            throw new IllegalArgumentException("Invalid vertex");

        if (!vertices.pertenece(v1) || !vertices.pertenece(v2))
            throw new IllegalArgumentException("Vertex does not exist in the graph");
        // Add the edge
        Nodo newNode = new Nodo(v2, peso);
        newNode = adjacencyList[v1];
        adjacencyList[v1] = newNode;
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        if (v1 < 0 || v1 >= capacity || v2 < 0 || v2 >= capacity)
            throw new IllegalArgumentException("Invalid vertex");

        if (adjacencyList[v1] == null) return;
        // Remove if it's the first node
        if (adjacencyList[v1].vertex == v2) {
            adjacencyList[v1] = adjacencyList[v1].next;
            return;
        }
        // Search and remove from the rest of the list
        Nodo current = adjacencyList[v1];
        while (current.next != null) {
            if (current.next.vertex == v2) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        if (v1 < 0 || v1 >= capacity || v2 < 0 || v2 >= capacity)
            throw new IllegalArgumentException("Invalid vertex");

        Nodo current = adjacencyList[v1];
        while (current != null) {
            if (current.vertex == v2) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int pesoArista(int v1, int v2) {
        if (v1 < 0 || v1 >= capacity || v2 < 0 || v2 >= capacity)
            throw new IllegalArgumentException("Invalid vertex");

        Nodo current = adjacencyList[v1];
        while (current != null) {
            if (current.vertex == v2) return current.weight;
            current = current.next;
        }
        throw new IllegalArgumentException("Edge does not exist");
    }
}
