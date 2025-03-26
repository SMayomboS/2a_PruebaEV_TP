package barcos;

public class Canoe extends Barco {
    public Canoe(String nombre) {
        super(nombre, 1);
    }

    @Override
    public void recibirAtaque(int posicion) {
        posiciones.set(0, true);
    }
}
