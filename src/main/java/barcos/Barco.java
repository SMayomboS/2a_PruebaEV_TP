package barcos;

import java.util.*;

public abstract class Barco implements Cloneable {
    protected String nombre;
    protected int tamaño;
    protected List<Boolean> posiciones;

    public Barco(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.posiciones = new ArrayList<>(Collections.nCopies(tamaño, false));
    }

    public abstract void recibirAtaque(int posicion);

    public boolean estaHundido() {
        return posiciones.stream().allMatch(b -> b);
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    @Override
    public Barco clone() {
        try {
            Barco copia = (Barco) super.clone();
            copia.posiciones = new ArrayList<>(this.posiciones);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
