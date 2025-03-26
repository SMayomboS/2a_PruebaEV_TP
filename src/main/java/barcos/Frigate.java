// src/barcos/Frigate.java
package barcos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Frigate")
public class Frigate extends Barco {

    public Frigate() {
        super("Default Frigate", 3);
    }

    public Frigate(String nombre) {
        super(nombre, 3);
    }

    @Override
    public void recibirAtaque(int posicion) {
        if (posicion >= 0 && posicion < getTamaño()) {
            getPosiciones().set(posicion, true);
        }
    }
}
