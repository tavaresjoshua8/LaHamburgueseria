package producto.acompañante;

import producto.Acompañante;

public class Refresco extends Acompañante {
    private String sabor = "Manzana";

    public Refresco(String tamaño, double precio, String sabor) {
        super("Refresco", precio, tamaño);
        this.setSabor(sabor);
    }

    // Getters
    public String getSabor() { return this.sabor; }
    // Setters
    public void setSabor(String sabor) { this.sabor = sabor; }
}
