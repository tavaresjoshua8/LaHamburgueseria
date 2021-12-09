package producto.acompañante;

import producto.Acompañante;

public class Boneless extends Acompañante {
    private String tipoSalsa = "Aderezo";
    
    public Boneless(String tamaño, String tipoSalsa) {
        super("Boneless", tamaño);
        this.setTipoSalsa(tipoSalsa);
    }

    // Getters
    public String getTipoSalsa() { return this.tipoSalsa; }
    // Setters
    public void setTipoSalsa(String tipoSalsa) { this.tipoSalsa = tipoSalsa; }
}
