// src/juego/GameManager.java
package juego;

import barcos.*;
import java.util.*;

public class GameManager {
    private Jugador jugador1;
    private Jugador jugador2;

    public GameManager(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void jugar() {
        while (true) {
            jugador1.atacar(jugador2);
            jugador2.atacar(jugador1);

            boolean p1 = jugador1.haPerdido();
            boolean p2 = jugador2.haPerdido();

            if (p1 && p2) {
                System.out.println("¡Empate!");
                break;
            } else if (p1) {
                System.out.println("¡" + jugador2.getNombre() + " gana!");
                break;
            } else if (p2) {
                System.out.println("¡" + jugador1.getNombre() + " gana!");
                break;
            }
        }
    }
}
