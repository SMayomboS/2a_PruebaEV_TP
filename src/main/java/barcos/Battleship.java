package barcos;

public class Battleship extends Barco {
    public Battleship(String nombre) {
        super(nombre, 5);
    }

    @Override
    public void recibirAtaque(int posicion) {
        if (posicion >= 0 && posicion < tamaño) {
            posiciones.set(posicion, true);
        }
    }
}
