package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimTDAImpl implements DiccionarioSimpleTDA {
    @Override
    public void InicializarDiccionario() {
        //
    }

    @Override
    public void Agregar(int clave, int valor) {
        //Permite añadir un elemento solo comprobando si ya existe
    }

    @Override
    public void Eliminar(int clave) {
        //
    }

    @Override
    public int Recuperar(int clave) {
        //Permite obtener el valor de una clave
        return 0;
    }

    @Override
    public ConjuntoTDA Claves() {
        //Permite tener el listado de todas las claves
        return null;
    }
}
