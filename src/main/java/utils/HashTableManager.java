package utils;

import barcos.Barco;

import java.util.*;

public class HashTableManager {

    // a. Tabla 1: por tipo
    private final Map<String, TablaTipo> tablaPorTipo = new HashMap<>();

    // b. Tabla 2: por número (tamaño 15)
    private final Barco[] tablaPorNumero = new Barco[15];

    // c. Tabla 3: por nombre
    private final Map<String, Barco> tablaPorNombre = new HashMap<>();

    public void cargarBarco(int numero, String nombre, String[] tipos, int nivel, Barco barco) {
        // c. Tabla por nombre
        tablaPorNombre.put(nombre, barco);

        // b. Tabla por número (posición fija en array de 15)
        if (numero >= 0 && numero < 15) {
            tablaPorNumero[numero] = barco;
        }

        // a. Tabla por tipo (posiblemente múltiples tipos)
        for (String tipo : tipos) {
            tipo = tipo.toLowerCase();

            tablaPorTipo.putIfAbsent(tipo, new TablaTipo(10)); // tamaño suficiente
            TablaTipo tabla = tablaPorTipo.get(tipo);

            int hash = tipo.hashCode();
            boolean insertado = tabla.insertar(barco, Math.abs(hash));
            if (!insertado) {
                System.out.println("⚠️ No se pudo insertar el barco " + nombre + " en la tabla por tipo: " + tipo);
            }
        }
    }

    public Barco getPorNombre(String nombre) {
        return tablaPorNombre.get(nombre);
    }

    public Barco getPorNumero(int numero) {
        return tablaPorNumero[numero];
    }

    public List<Barco> getPorTipo(String tipo) {
        TablaTipo tabla = tablaPorTipo.get(tipo.toLowerCase());
        if (tabla == null) return new ArrayList<>();
        return Arrays.stream(tabla.getBarcos())
                .filter(Objects::nonNull)
                .toList();
    }
}
