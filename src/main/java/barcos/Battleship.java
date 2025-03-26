// src/barcos/Battleship.java
package barcos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Battleship")
public class Battleship extends Barco {
    public Battleship() {
        super("Default Battleship", 5);
    }

    public Battleship(String nombre) {
        super(nombre, 5);
    }

    @Override
    public void recibirAtaque(int posicion) {
        if (posicion >= 0 && posicion < getTamaño()) {
            getPosiciones().set(posicion, true);
        }
    }
}
