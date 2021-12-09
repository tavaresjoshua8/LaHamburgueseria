package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import cliente.Cliente;
import factura.Factura;
import producto.Producto;

public abstract class Ventas {
    private static final String SEPARADOR = ", ";
    private static final String SEPARADOR_PRODUCTOS = " - ";
    private static final File VENTAS = new File("files\\ventas.txt");

    public static void guardarVenta(Factura factura) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(VENTAS, true));

            /*
                    CLIENTE             |
            RFC | Razon Social | Correo |

                    Productos
            Nombre | Precio
            */

            Cliente c = factura.getCliente();
            Producto[] productos = factura.getProductos();
            pw.println(c.getRFC() + SEPARADOR + c.getRazonSocial() + SEPARADOR + c.getCorreo());
            for(int i = 0; i<productos.length; i++) {
                if(i != 0)
                    pw.print(SEPARADOR_PRODUCTOS);
                Producto p = productos[i];
                pw.print(p.getNombre() + SEPARADOR + p.getPrecio());
            }
            pw.print("\n");

            pw.close();
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void mostrarVentas() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(VENTAS));

            String linea = br.readLine();
            while(linea != null) {
                String aux[] = linea.split(SEPARADOR);
                System.out.println("Cliente");
                System.out.println("\tRFC: " + aux[0]);
                System.out.println("\tRazon Social: " + aux[1]);
                System.out.println("\tCorreo: " + aux[2]);
                linea = br.readLine();
                String aux2[] = linea.split(SEPARADOR_PRODUCTOS);
                System.out.println("Productos");
                for(String productos : aux2) {
                    String aux3[] = productos.split(SEPARADOR);
                    System.out.println("\t" + aux3[0] + ": $" + aux3[1]);
                }

                linea = br.readLine();
            }
            br.close();
        } catch(IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mostrarVentas();
    }
}
