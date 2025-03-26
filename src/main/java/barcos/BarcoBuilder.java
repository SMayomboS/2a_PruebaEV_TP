package barcos;

public class BarcoBuilder {
    private String nombre;
    private String tipo;

    public BarcoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public BarcoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public Barco build() {
        return switch (tipo.toLowerCase()) {
            case "battleship" -> new Battleship(nombre);
            case "frigate" -> new Frigate(nombre);
            case "canoe" -> new Canoe(nombre);
            default -> throw new IllegalArgumentException("Tipo de barco desconocido");
        };
    }
}
