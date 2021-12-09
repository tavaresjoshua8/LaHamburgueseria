package producto;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hamburguesa extends Producto {
    private String tipo = "Sencilla";
    private ArrayList <Ingrediente> ingredientes = new ArrayList<>();

    public Hamburguesa(Hamburguesa hamburguesa) {
        super(NOMBRE, hamburguesa.precio);
        this.setTipo(hamburguesa.tipo);
        this.ingredientes = hamburguesa.ingredientes;
    }

    public Hamburguesa(double precio, String tipo, Ingrediente[] ingredientes) {
        super(NOMBRE, precio);
        this.setTipo(tipo);
        this.setIngredientes(ingredientes);
    }

    @Override
    public String toString() {
        String ingredientes = this.ingredientes.stream().filter(i -> i.getPrecio() <= 0)
            .map(i -> "\t\t" + i)
            .collect(Collectors.joining());

        String ingredientesExtra = this.ingredientes.stream().filter(i -> i.getPrecio() > 0)
            .map(i -> "\t\t" + i)
            .collect(Collectors.joining());

        return this.nombre + " " + this.tipo + "\n"
                + "\tPrecio: " + this.precio + "\n"
                + "\tIngredientes: \n" + ingredientes
                + (ingredientesExtra.isEmpty() ? "" : "\tExtras:\n" + ingredientesExtra);
    }

    @Override
    public Hamburguesa clone() {
        return new Hamburguesa(this);
    }

    // Getters
    public String getTipo() { return this.tipo; }
    public Ingrediente[] getIngredientes() {
        return this.ingredientes.toArray(new Ingrediente[0]); 
    }
    // Setters
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setIngredientes(Ingrediente[] ingredientes) {
        for (Ingrediente ingrediente : ingredientes) {
            ingrediente = ingrediente.clone(); // Clone para evitar que se modifique el original
            ingrediente.setPrecio(0); // Los ingredientes base no llevan un costo extra
            this.agregarIngrediente(ingrediente);
        }
    }

    // Metodos
    public void agregarIngrediente(Ingrediente ingrediente) {
        if(this.ingredientes.contains(ingrediente)) { // Si ya cuenta con ese ingrediente, se cambia la cantidad
            Ingrediente temp = this.ingredientes.get(this.ingredientes.indexOf(ingrediente));
            temp.setCantidad(temp.getCantidad() + ingrediente.getCantidad());
        } else { // Si no, se agrega
            this.ingredientes.add(ingrediente);
        }
    }

    public void quitarIngrediente(int index) {
        System.out.println("Se ha eliminado " + this.ingredientes.get(index).getNombre() + ".");
        this.ingredientes.remove(index);
    }

    @Override
    public double getPrecio() {
        double precio = this.precio;
        for(Ingrediente i : this.ingredientes) {
            precio += i.getPrecio();
        }
        return precio;
    }

    // Static Variables
    public static final String NOMBRE = "Hamburguesa";
}
