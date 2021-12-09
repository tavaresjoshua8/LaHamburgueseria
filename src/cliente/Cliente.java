package cliente;

public class Cliente {
    private static int contador = 0;
    private int noCliente = ++contador;
    private String RFC;
    private String razonSocial;
    private String correo;

    public Cliente(String RFC, String razonSocial, String correo) {
        this.setRFC(RFC);
        this.setRazonSocial(razonSocial);
        this.setCorreo(correo);
    }

    @Override
    public String toString(){
        return "Cliente #" + this.noCliente + "\n"
                + "\tRFC: " + this.RFC + "\n"
                + "\tRazon Social: " + this.razonSocial + "\n"
                + "\tCorreo: " + this.correo;
    }

    // Getters
    public int getNoDeCliente() { return this.noCliente; }
    public String getRFC() { return this.RFC; }
    public String getRazonSocial() { return this.razonSocial; }
    public String getCorreo() { return this.correo; }
    // Setters
    public void setRFC(String RFC) { this.RFC = RFC; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    public void setCorreo(String correo) { this.correo = correo; }
}