package factura;

import java.util.ArrayList;

import cliente.Cliente;
import producto.Producto;

public class Factura {
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private Cliente cliente;

    public Factura() { }

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        String factura = "";
        factura += this.cliente + "\n";
        factura += "Productos: \n";
        for (Producto producto : productos) {
            factura += producto.toString();
        }
        factura += "Total: $" + this.calcularTotal() + "\n";
        return factura;
    }

    // Getters
    public Cliente getCliente() { return this.cliente; }
    public Producto[] getProductos() { return this.productos.toArray(new Producto[0]); }
    // Setters
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setProductos(Producto[] productos) {
        for (Producto producto : productos) {
            this.productos.add(producto);
        }
    }

    // Metodos
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public double calcularTotal() {
        double precioTotal = 0;
        for (Producto producto : this.productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    // Static Variables
    public static final double IVA = 0.08; // 8% por que somos un negocio de frontera
}
