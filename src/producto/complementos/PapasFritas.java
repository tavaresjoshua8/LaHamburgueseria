package producto.complementos;

import producto.Complemento;

public class PapasFritas extends Complemento {
    private String aderezo = "Queso";

    public PapasFritas(String tamaño, String aderezo) {
        super("Papas Fritas", tamaño);
        this.setAderezo(aderezo);
    }

    // Getters
    public String getAderezo() { return this.aderezo; }
    // Setters
    public void setAderezo(String aderezo) { this.aderezo = aderezo; }
}
