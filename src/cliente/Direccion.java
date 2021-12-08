package cliente;

public class Direccion {
    private int numero;
    private int codigoPostal;
    private String calle;
    private String colonia;
    private String ciudad;
    private String estado;

    public Direccion(String calle, int numero, String colonia, int codigoPostal, String ciudad, String estado) {
        this.setCalle(calle);
        this.setNumero(numero);
        this.setColonia(colonia);
        this.setCodigoPostal(codigoPostal);
        this.setCiudad(ciudad);
        this.setEstado(estado);
    }

    @Override
    public String toString(){
        return this.calle + " " + this.numero + " " + this.colonia + "\n"
                + "Codigo Postal: " + this.codigoPostal + "\n"
                + "Localidad: " + this.ciudad + ", " + this.estado;
    }

    // Getters
    public int getNumero() { return this.numero; }
    public int getCodigoPostal() { return codigoPostal; }
    public String getCalle() { return this.calle;}
    public String getColonia() { return this.colonia; }
    public String getCiudad() { return this.ciudad; }
    public String getEstado() { return this.estado; }
    // Setters
    public void setNumero(int numero) { 
        this.numero = Math.abs(numero);
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = Math.abs(codigoPostal);
    }
    public void setCalle(String calle) { this.calle=calle; }
    public void setColonia(String colonia) { this.colonia=colonia; }
    public void setCiudad(String ciudad) { this.ciudad=ciudad; }
    public void setEstado(String estado) { this.estado=estado; }
}
