package producto;

public class Ingrediente extends Producto {
    private int cantidad = 1;
    // Ingrediente Extra llevara un precio
    public Ingrediente(String nombre, double precio) {
        super(nombre, precio);
    }

    // Ingrediente Base sera gratuito
    public Ingrediente(String nombre) {
        super(nombre, 0);
    }

    // Constructor usado para clonar
    public Ingrediente(Ingrediente ingrediente) {
        super(ingrediente.getNombre(), ingrediente.getPrecio());
        this.setCantidad(ingrediente.getCantidad());
    }

    // Getters
    public int getCantidad() { return this.cantidad; }
    // Setters
    public void setCantidad(int cantidad) { this.cantidad = Math.abs(cantidad); }

    // Metodos
    public Ingrediente clone() {
        return new Ingrediente(this);
    }

    @Override
    public String toString() {
        if( precio <= 0 )
            return this.nombre + (this.cantidad > 1 ? ": " + this.cantidad : "") + "\n";

        return this.nombre + ": " + this.cantidad + " x $" + this.precio + " = $" + this.getPrecio() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) 
            return false;
            
        Ingrediente ingrediente = (Ingrediente) obj;
        return this.nombre.equals(ingrediente.getNombre()) && this.precio == ingrediente.getPrecio();
    }

    @Override
    public double getPrecio() {
        return this.cantidad * this.precio;
    }
}
