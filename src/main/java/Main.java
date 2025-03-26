// src/Main.java
import barcos.Barco;
import juego.*;
import servicios.BarcoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TableroBuilder tableroBuilder = new TableroBuilder();
        BarcoService barcoService = new BarcoService();

        System.out.println("Jugador 1, introduce tu nombre:");
        String nombre1 = sc.nextLine();
        Tablero tablero1 = tableroBuilder.build();
        Jugador jugador1 = new Jugador(nombre1, tablero1);
        configurarBarcos(jugador1, sc, barcoService);

        System.out.println("Jugador 2, introduce tu nombre:");
        String nombre2 = sc.nextLine();
        Tablero tablero2 = tableroBuilder.build();
        Jugador jugador2 = new Jugador(nombre2, tablero2);
        configurarBarcos(jugador2, sc, barcoService);

        GameManager juego = new GameManager(jugador1, jugador2);
        juego.jugar();
    }

    private static void configurarBarcos(Jugador jugador, Scanner sc, BarcoService barcoService) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce tipo de barco (Battleship, Frigate, Canoe): ");
            String tipo = sc.nextLine();
            System.out.println("Introduce nombre del barco: ");
            String nombre = sc.nextLine();
            System.out.println("Introduce número del barco (0-14): ");
            int numero = sc.nextInt();
            System.out.println("Introduce nivel del barco (opcional): ");
            int nivel = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            // Creamos y registramos el barco (en DB + Hash)
            barcoService.crearYRegistrarBarco(numero, nombre, new String[]{tipo}, nivel);
            Barco barco = barcoService.buscarPorNombre(nombre);

            // Colocar barco en tablero
            System.out.println("Fila de inicio (0-9): ");
            int fila = sc.nextInt();
            System.out.println("Columna de inicio (0-9): ");
            int col = sc.nextInt();
            System.out.println("¿Horizontal? true/false:");
            boolean horizontal = sc.nextBoolean();
            sc.nextLine(); // limpiar buffer

            boolean colocado = jugador.getTablero().colocarBarco(barco, fila, col, horizontal);
            if (!colocado) {
                System.out.println("❌ No se pudo colocar el barco. Intenta de nuevo.");
                i--;
            }
        }
    }
}
