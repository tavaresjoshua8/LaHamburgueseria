package producto;

public class Acompañante extends Producto{
    private String tamaño;

    public Acompañante(String nombre, String tamaño) {
        super(nombre);
        this.setTamaño(tamaño);
        this.precioTamaño();
    }

    public void precioTamaño() {
        if(this.tamaño.equalsIgnoreCase("Chico"))
            this.setPrecio(20);
        else if(this.tamaño.equalsIgnoreCase("Mediano"))
            this.setPrecio(30);
        else this.setPrecio(40);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.tamaño + ": $" + this.precio;
    }

    // Getters
    public String getTamaño() { return this.tamaño; }
    // Setters
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }
}
