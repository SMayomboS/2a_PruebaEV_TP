package servicios;

import barcos.*;
import utils.BarcoRepository;
import utils.HashTableManager;

public class BarcoService {
    private final BarcoRepository repo = new BarcoRepository();
    private final HashTableManager hashManager = new HashTableManager();

    public void crearYRegistrarBarco(int numero, String nombre, String[] tipos, int nivel) {
        BarcoBuilder builder = new BarcoBuilder().setNombre(nombre).setTipo(tipos[0]);
        Barco barco = builder.build();

        // Persistimos el barco
        repo.guardarBarco(barco);

        // Indexamos en tablas hash
        hashManager.cargarBarco(numero, nombre, tipos, nivel, barco);

        System.out.println("✅ Barco '" + nombre + "' registrado y persistido con éxito.");
    }

    // Métodos de consulta
    public Barco buscarPorNombre(String nombre) {
        return hashManager.getPorNombre(nombre);
    }

    public Barco buscarPorNumero(int numero) {
        return hashManager.getPorNumero(numero);
    }

    public void imprimirBarcosPorTipo(String tipo) {
        var barcos = hashManager.getPorTipo(tipo);
        System.out.println("Barcos tipo '" + tipo + "':");
        for (Barco b : barcos) {
            System.out.println("- " + b.getNombre());
        }
    }
}
