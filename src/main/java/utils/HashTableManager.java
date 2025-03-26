package utils;

import barcos.Barco;

import java.util.*;

public class HashTableManager {
    private final Map<String, List<Barco>> porTipo = new HashMap<>();
    private final Barco[] porNumero = new Barco[15];
    private final Map<String, Barco> porNombre = new HashMap<>();

    public void cargarBarco(Barco barco, int numero, String tipo) {
        // Tabla por tipo
        porTipo.computeIfAbsent(tipo.toLowerCase(), k -> new ArrayList<>()).add(barco);

        // Tabla por número
        if (numero >= 0 && numero < porNumero.length) {
            porNumero[numero] = barco;
        }

        // Tabla por nombre
        porNombre.put(barco.getNombre(), barco);
    }

    public List<Barco> getBarcosPorTipo(String tipo) {
        return porTipo.getOrDefault(tipo.toLowerCase(), new ArrayList<>());
    }

    public Barco getBarcoPorNumero(int numero) {
        return porNumero[numero];
    }

    public Barco getBarcoPorNombre(String nombre) {
        return porNombre.get(nombre);
    }
}
