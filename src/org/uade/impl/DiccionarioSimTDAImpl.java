package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimTDAImpl implements DiccionarioSimpleTDA {
    private static class DictNode {
        private int key;
        private int value;
        private DictNode next;
        //private DictNode prev;

        public DictNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            //this.prev = null;
        }
    }
    private DictNode head;
    private int size;

    @Override
    public void inicializarDiccionario() {
        head = null;
        size = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        if (!existe(clave)) {
            DictNode newNode = new DictNode(clave, valor);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
    private boolean existe(int clave) {
        DictNode current = head;
        while (current != null) {
            if (current.key == clave) return true;
            current = current.next;
        }
        return false;
    }
    @Override
    public void eliminar(int clave) {
        if(head != null){
            if (head.key == clave) {
                head = head.next;
                size--;
                return;
            }
            DictNode current = head;
            while (current.next != null && current.next.key != clave) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                size--;
            }
        }
    }
    @Override
    public int recuperar(int clave) {
        DictNode current = head;
        while (current != null) {
            if (current.key == clave) return current.value;
            current = current.next;
        }
        throw new IllegalArgumentException("Key not found in dictionary");
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoTDAImpl();
        DictNode current = head;
        while (current != null) {
            claves.agregar(current.key);
            current = current.next;
        }
        return claves;
    }
}
