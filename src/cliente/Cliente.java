package cliente;

public class Cliente {
    private static int noCliente = 0;
    private String RFC;
    private String razonSocial;
    private Direccion domicilio;
    private String correo;

    public Cliente(String RFC, String razonSocial, String correo, Direccion domicilio) {
        Cliente.noCliente++;
        this.setRFC(RFC);
        this.setRazonSocial(razonSocial);
        this.setDomicilio(domicilio);
        this.setCorreo(correo);
    }

    @Override
    public String toString(){
        return "Cliente: " + noCliente + "\n"
                + "RFC: " + this.RFC + "\n"
                + "Razon Social: " + this.razonSocial + "\n"
                + "Domicilio: " + this.domicilio + "\n"
                + "Correo: " + this.correo;
    }

    // Getters
    public int getNoDeCliente() { return noCliente; }
    public String getRFC() { return RFC; }
    public String getRazonSocial() { return razonSocial; }
    public Direccion getDomicilio() { return domicilio; }
    public String getCorreo() { return correo; }
    // Setters
    public void setRFC(String RFC) { this.RFC = RFC; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    public void setDomicilio(Direccion domicilio) { this.domicilio = domicilio; }
    public void setCorreo(String correo) { this.correo = correo; }
}