package juego;

import barcos.Barco;
import java.util.*;

public class Tablero {
    private final int tamaño = 10;
    private Barco[][] tablero = new Barco[tamaño][tamaño];
    private List<Barco> barcos = new ArrayList<>();

    public boolean colocarBarco(Barco barco, int fila, int columna, boolean horizontal) {
        int largo = barco.getTamaño();
        if (horizontal) {
            if (columna + largo > tamaño) return false;
            for (int i = 0; i < largo; i++) {
                if (tablero[fila][columna + i] != null) return false;
            }
            for (int i = 0; i < largo; i++) {
                tablero[fila][columna + i] = barco;
            }
        } else {
            if (fila + largo > tamaño) return false;
            for (int i = 0; i < largo; i++) {
                if (tablero[fila + i][columna] != null) return false;
            }
            for (int i = 0; i < largo; i++) {
                tablero[fila + i][columna] = barco;
            }
        }
        barcos.add(barco);
        return true;
    }

    public boolean recibirAtaque(int fila, int columna) {
        Barco barco = tablero[fila][columna];
        if (barco != null) {
            int index = calcularIndice(barco, fila, columna);
            barco.recibirAtaque(index);
            return true;
        }
        return false;
    }

    public boolean todosHundidos() {
        return barcos.stream().allMatch(Barco::estaHundido);
    }

    private int calcularIndice(Barco barco, int fila, int columna) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] == barco) {
                    return barco.getTamaño() == 1 ? 0 : (i == fila ? columna - j : fila - i);
                }
            }
        }
        return 0;
    }
}
