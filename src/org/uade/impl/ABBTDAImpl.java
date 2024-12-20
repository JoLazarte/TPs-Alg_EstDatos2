package org.uade.impl;

import org.uade.api.ABBTDA;

public class ABBTDAImpl  implements ABBTDA {
    private Nodo root;

    // Node inner class
    private static class Nodo {
        private int value;
        private Nodo hijoIzq;
        private Nodo hijoDer;

        public Nodo(int value) {
            this.value = value;
            this.hijoIzq = null;
            this.hijoDer = null;
        }
    }

    @Override
    public void inicializarArbol() {
        this.root = null;

    }

    @Override
    public int raiz() {
        return root.value;
    }

    @Override
    public ABBTDA hijoIzq() {
        if (root == null) {
            return null;
        }
        ABBTDA subArbolIzq = new ABBTDAImpl();
        if(root.hijoIzq != null) {
            subArbolIzq.agregar(root.hijoIzq.value);
            return subArbolIzq;
        }
        return  null;
    }

    @Override
    public ABBTDA hijoDer() {
        if (root == null) {
            return null;
        }
        ABBTDA subArbolDer = new ABBTDAImpl();
        if(root.hijoDer != null) {
            subArbolDer.agregar(root.hijoDer.value);
            return subArbolDer;
        }
        return null;
    }

    @Override
    public void agregar(int x) {
       insertNodo(root, x);
    }
    private Nodo insertNodo(Nodo current, int n) {
        if (current == null) return  new Nodo(n);
        if (current.value == n)  return current;
        if (n < current.value) current.hijoIzq = insertNodo(current.hijoIzq, n);
        if (n > current.value) current.hijoDer = insertNodo(current.hijoDer, n);
        return current;
    }

    @Override
    public void eliminar(int x) {
        //root = deleteNodo(root, x);
        deleteNodo(root, x);
    }

    private Nodo deleteNodo(Nodo current, int n) {
        if (current == null) return null;
        if (n < current.value) current.hijoIzq = deleteNodo(current.hijoIzq, n);
        if (n > current.value) current.hijoDer = deleteNodo(current.hijoDer, n);
        else {
            // Node "current" with only one child or no child
            if (current.hijoIzq== null) return current.hijoDer;
            if (current.hijoDer== null) return current.hijoIzq;
            // Node "current" with two children: Get the inorder successor (smallest in the right subtree)
            current.value = minValue(current.hijoDer);
            // Delete the inorder successor
            current.hijoDer = deleteNodo(current.hijoDer, current.value);
        }
        return current;
    }

    private int minValue(Nodo origen) {
        int min = origen.value; //inicializo el valor min
        while (origen.hijoIzq != null) { //busco el valor min
            min = origen.hijoIzq.value;
            origen = origen.hijoIzq; //actualizo el loop
        }
        return min;
    }

    @Override
    public boolean arbolVacio() {
        return root == null;
    }

}