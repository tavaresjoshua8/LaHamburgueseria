import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import factura.Factura;
import predefined.Ingredientes;
import producto.Ingrediente;

public abstract class Hamburgueseria {
    private final static Scanner input = new Scanner(System.in);
    private final static String NOMBRE = "La Hamburgueseria";
    private final static ArrayList<Factura> facturas = new ArrayList<Factura>();

    // Metodos
    public static void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    // main
    public static void main(String[] args) {
        while(true) {
            Factura nueva = new Factura();
        }
    }

    public static int menu() {
        System.out.println("");

        return leerEntero("Ingrese la accion: ", 0);
    }

    public static int menuHamburguesas() {
        System.out.println("=============================================");
        System.out.println("1.- Hamburguesa Sencilla");
        System.out.println("2.- Hamburguesa Doble");
        System.out.println("3.- HamburPizza");
        System.out.println("4.- Hamburguesa Carnivora");
        System.out.println("5.- Chicken Burger");
        System.out.println("6.- Hamburguesa BBQ");
        System.out.println("=============================================");

        return leerEntero("Ingrese el numero de la hamburguesa que desea: ", 6);
    }

    public static int menuIngredientes() {
        System.out.println("=============================================");
        System.out.printf("%2s | %-20s | %s\n", "ID", "Nombre", "Precio");
        System.out.println("=============================================");
        for(int i = 0; i<Ingredientes.ingredientes.length; i++) {
            Ingrediente temp = Ingredientes.ingredientes[i];
            System.out.printf("%2d | %-20s | $%.2f\n", i+1, temp.getNombre(), temp.getPrecio());
        }
        System.out.println("=============================================");

        return leerEntero("Ingrese el numero del ingrediente que desea: ", Ingredientes.ingredientes.length);
    }

    // Util
    public static int leerEntero(String msg, int max) {
        System.out.print(msg);
        try {
            int num = input.nextInt();
            
            if(num < 0 || num > max) {
                System.out.println("El numero ingresado no es valido.");
                return leerEntero(msg, max);
            }

            return num;
        } catch (InputMismatchException e) {
            input.nextLine();
            System.err.println("ERROR: Ingrese un numero entero valido o '0' para cancelar.");
            return leerEntero(msg, max);
        }
    }
}
