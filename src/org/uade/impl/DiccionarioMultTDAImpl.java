package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioMultipleTDA;

public class DiccionarioMultTDAImpl implements DiccionarioMultipleTDA {
    private static class DictNodoMult {
        private int key;
        private ValueNode values;
        private DictNodoMult next;

        public DictNodoMult(int key) {
            this.key = key;
            this.values = null;
            this.next = null;
        }
    }
    private static class ValueNode {
        private int valueN;
        private ValueNode nextN;

        public ValueNode(int value) {
            this.valueN = value;
            this.nextN = null;
        }
    }
    private DictNodoMult  head;
    private int size;

    @Override
    public void inicializarDiccionario() {
        head = null;
        size = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        // Find or create the dictionary node for this key
        DictNodoMult dictNode = findDictionaryNode(clave);
        if (dictNode == null) {
            // Create new dictionary node
            dictNode = new DictNodoMult(clave);
            dictNode.next = head;
            head = dictNode;
        }
        // Add the value to the value list
        ValueNode newValue = new ValueNode(valor);
        newValue.nextN = dictNode.values;
        dictNode.values = newValue;
        size++;
    }


    @Override
    public void eliminar(int clave) {
    // Delete all values associated with a key
        if (head != null){
        // If key is in head node
            if (head.key == clave) {
                head = head.next;
                return;
            }
            // Search for the key
            DictNodoMult current = head;
            while (current.next != null) {
                if (current.next.key == clave) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    }
    @Override
    public void eliminarValor(int clave, int valor) {
        DictNodoMult dictNode = findDictionaryNode(clave);
        if (dictNode == null) return;
        ValueNode values = dictNode.values;
        if (values == null) return;

        // If the value is in the first node
        if (values.valueN == valor) {
            dictNode.values = values.nextN;
            size--;
            // If this was the last value for this key, remove the key
            if (dictNode.values== null) {
               eliminar(clave);
            }
            return;
        }
        // Search for the value in the rest of the list
        ValueNode current = values;
        while (current.nextN != null) {
            if (current.nextN.valueN == valor) {
                current.nextN = current.nextN.nextN;
                size--;
                return;
            }
            current = current.nextN;
        }
    }

    // Helper method to find a dictionary node by key
    private DictNodoMult findDictionaryNode(int clave) {
        DictNodoMult current = head;
        while (current != null) {
            if (current.key == clave) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    @Override
    public ConjuntoTDA recuperar(int clave) {
    // Get all values associated with a key
        ConjuntoTDA valueSet = new ConjuntoTDAImpl();

        DictNodoMult dictNode = findDictionaryNode(clave);
        if (dictNode == null) return valueSet;

        ValueNode current = dictNode.values;
        while (current != null) {
            valueSet.agregar(current.valueN);
            current = current.nextN;
        }

        return valueSet;
    }
    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoTDAImpl();
        DictNodoMult current = head;
        while (current != null) {
            claves.agregar(current.key);
            current = current.next;
        }
        return claves;
    }
}
