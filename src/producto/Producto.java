package producto;

public class Producto {
    protected String nombre = "No definido";
    protected double precio = 0.0;

    public Producto(String nombre) {
        this.setNombre(nombre);
    }

    public Producto(String nombre, double precio) {
        this.setNombre(nombre);
        this.setPrecio(precio);
    }

    @Override
    public String toString() {
        return this.nombre + ": $" + this.precio;
    }

    // Getters
    public String getNombre() { return this.nombre; }
    public double getPrecio() { return this.precio; }
    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) {
        this.precio = Math.abs(precio);
    }
}