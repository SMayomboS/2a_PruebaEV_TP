package barcos;

public class Frigate extends Barco {
    public Frigate(String nombre) {
        super(nombre, 3);
    }

    @Override
    public void recibirAtaque(int posicion) {
        if (posicion >= 0 && posicion < tamaño) {
            posiciones.set(posicion, true);
        }
    }
}
