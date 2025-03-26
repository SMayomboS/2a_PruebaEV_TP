package juego;

import barcos.Barco;
import java.util.*;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private Random random = new Random();

    public Jugador(String nombre, Tablero tablero) {
        this.nombre = nombre;
        this.tablero = tablero;
    }

    public boolean atacar(Jugador otro) {
        int fila = random.nextInt(10);
        int col = random.nextInt(10);
        return otro.getTablero().recibirAtaque(fila, col);
    }

    public boolean haPerdido() {
        return tablero.todosHundidos();
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }
}
