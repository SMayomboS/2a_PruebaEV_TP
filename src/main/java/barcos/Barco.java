// src/barcos/Barco.java
package barcos;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int tamaño;

    @ElementCollection
    private List<Boolean> posiciones = new ArrayList<>();

    public Barco() {}

    public Barco(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.posiciones = new ArrayList<>(Collections.nCopies(tamaño, false));
    }

    public abstract void recibirAtaque(int posicion);

    public boolean estaHundido() {
        return posiciones.stream().allMatch(Boolean::booleanValue);
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public List<Boolean> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(List<Boolean> posiciones) {
        this.posiciones = posiciones;
    }
}
