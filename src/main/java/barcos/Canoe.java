// src/barcos/Canoe.java
package barcos;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Canoe")
public class Canoe extends Barco {

    public Canoe() {
        super("Default Canoe", 1);
    }

    public Canoe(String nombre) {
        super(nombre, 1);
    }

    @Override
    public void recibirAtaque(int posicion) {
        getPosiciones().set(0, true);
    }
}
