package producto;

public class Acompañante extends Producto{
    private String tamaño;

    public Acompañante(String nombre, double precio, String tamaño) {
        super(nombre, precio);
        this.setTamaño(tamaño);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.tamaño + ": $" + this.precio + "\n";
    }

    // Getters
    public String getTamaño() { return this.tamaño; }
    // Setters
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }
}
