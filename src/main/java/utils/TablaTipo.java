package utils;

import barcos.Barco;

public class TablaTipo {
    private final int capacidad;
    private final Barco[] tabla;

    public TablaTipo(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Barco[capacidad];
    }

    public boolean insertar(Barco barco, int hashInicial) {
        int index = hashInicial % capacidad;
        for (int i = 0; i < capacidad; i++) {
            int actual = (index + i) % capacidad;
            if (tabla[actual] == null) {
                tabla[actual] = barco;
                return true;
            }
        }
        return false;
    }

    public Barco[] getBarcos() {
        return tabla;
    }
}
