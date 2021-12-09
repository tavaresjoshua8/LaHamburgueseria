package producto.complementos;

import producto.Complemento;

public class Refresco extends Complemento {
    private String sabor = "Manzana";

    public Refresco(String tamaño, String sabor) {
        super("Refresco", tamaño);
        this.setSabor(sabor);
    }

    // Getters
    public String getSabor() { return this.sabor; }
    // Setters
    public void setSabor(String sabor) { this.sabor = sabor; }
}
