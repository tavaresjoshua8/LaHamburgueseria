import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cliente.Cliente;
import factura.Factura;
import predefined.Ingredientes;
import producto.acompañante.*;
import producto.Acompañante;
import producto.Hamburguesa;
import producto.Ingrediente;
import producto.Producto;

public abstract class Hamburgueseria {
    private final static Scanner input = new Scanner(System.in);
    private final static String NOMBRE = "La Hamburgueseria";
    private final static ArrayList<Factura> facturas = new ArrayList<Factura>();
    private static Hamburguesa[] hamburguesas={
        new Hamburguesa(35,"Sencilla",Ingredientes.SENCILLA),
        new Hamburguesa(55,"Doble",Ingredientes.DOBLE),
        new Hamburguesa(75,"HamburPizza",Ingredientes.HAMBURPIZZA),
        new Hamburguesa(75,"Carnivora",Ingredientes.CARNIVORA),
        new Hamburguesa(45,"Chicken Burguer",Ingredientes.CHIKENBURGUER),
        new Hamburguesa(45,"BBQ",Ingredientes.BBQ)
    };

    // main
    public static void main(String[] args) {
        while(true) {
            int opcion = menu();

            if(opcion == 0) break;

            Factura factura = new Factura();
            switch(opcion){
                case 1:
                    while(true) {
                        int opcionPedido = menuPedido();

                        if(opcionPedido == 0) break;

                        while(true) {
                            int opcionProducto = menuProducto();
                            String tamaño = null;
                            Acompañante complemento = null;

                            if(opcionProducto == 0) break;

                            if(opcionProducto != 1) {
                                tamaño = menuTamaños();
                                if(tamaño == null) break;
                            }

                            switch(opcionProducto) {
                                case 1:
                                    int opcionHamburguesa = menuHamburguesas();
                                    
                                    if(opcionHamburguesa == 0) break;

                                    Hamburguesa hamburguesa = (hamburguesas[opcionHamburguesa - 1]).clone();
                                    System.out.print("Desea agregar ingredientes extra? s/n: ");
                                    if(input.nextLine().charAt(0) == 's') {
                                        while(true) {
                                            int opcionIngrediente = menuIngredientes();

                                            if(opcionIngrediente == 0) break;

                                            hamburguesa.agregarIngrediente(Ingredientes.ingredientes[opcionIngrediente - 1]);
                                            System.out.println(Ingredientes.ingredientes[opcionIngrediente-1].getNombre() + " ha sido agregado.");
                                        }
                                    }
                                    System.out.print("Desea remover ingredientes? s/n: ");
                                    if(input.nextLine().charAt(0) == 's') {
                                        while(true) {
                                            int opcionIngrediente = menuIngredientesRemovibles(hamburguesa);

                                            if(opcionIngrediente == 0) break;

                                            hamburguesa.quitarIngrediente(opcionIngrediente - 1);
                                        }
                                    }
                                    factura.agregarProducto(hamburguesa);
                                    System.out.println("Se ha agregado " + hamburguesa.getNombre() + " " + hamburguesa.getTipo() + ": $" + hamburguesa.getPrecio());
                                    break;
                                case 2:
                                    String salsa=menuSalsa();
                                    if(salsa == null) break;
                                    complemento = new Boneless(tamaño, salsa);
                                    break;
                                    
                                case 3:
                                    String aderezo=menuAderezo();
                                    if(aderezo == null) break;
                                    complemento = new PapasFritas(tamaño,aderezo);
                                    break;
                                    
                                case 4:
                                    String sabor=menuSabor();
                                    if(sabor == null) break;
                                    complemento = new Refresco(tamaño, sabor);
                            }

                            if(opcionProducto != 1) {
                                factura.agregarProducto(complemento);
                                System.out.println("Se ha agregado " + complemento);
                            }
                        }
                    }

                    System.out.print("Desea facturar? s/n: ");
                    if(input.nextLine().charAt(0) == 's') {
                        System.out.println("Capturando los datos del cliente.");
                        System.out.print("Ingrese el RFC: ");
                        String rfc = input.nextLine();
                        System.out.print("Ingrese la Razon Social: ");
                        String razonSocial = input.nextLine();
                        System.out.print("Ingrese un correo: ");
                        String correo = input.nextLine();

                        factura.setCliente(new Cliente(rfc, razonSocial, correo));
                    } else {
                        double total = 0;
                        for(Producto p : factura.getProductos()) {
                            System.out.println(p);
                            total += p.getPrecio();
                        }
                        System.out.println("Total a pagar: $" + total);
                    }

                    facturas.add(factura);
                    break;
                case 2:
                    break;
                
            }
        };

        //corte de caja
        if(facturas.isEmpty()) {
            System.out.println("No se registro ninguna venta hoy");
            return;
        }

        double suma = 0;
        for(Factura f : facturas) {
            suma += f.calcularTotal();
        }
        System.out.println("Total en caja: " + suma);
    }

    public static int menu() {
        System.out.println("=============================================");
        System.out.println("1.- Ingresar pedido");
        System.out.println("2.- Ingresar en almacen");
        System.out.println("0.- Corte caja");
        System.out.println("=============================================");

        return leerEntero("Ingrese la accion: ", 2);
    }
    
    public static int menuPedido() {
        System.out.println("=============================================");
        System.out.println("1.- Ingresar un producto");
        System.out.println("0.- Totalizar y Facturizar");
        System.out.println("=============================================");

        return leerEntero("Ingrese la accion: ", 1);
    }
    
    public static int menuProducto() {
        System.out.println("=============================================");
        System.out.println("1.- Hamburguesa");
        System.out.println("2.- Boneless");
        System.out.println("3.- Papas fritas");
        System.out.println("4.- Refresco");
        System.out.println("=============================================");

        return leerEntero("Ingrese el numero del producto que desea: ", 4);
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

    public static int menuIngredientesRemovibles(Hamburguesa hamburguesa) {
        Ingrediente[] ingredientes = hamburguesa.getIngredientes();
        System.out.println("=============================================");
        for(int i = 0; i < ingredientes.length; i++) {
            System.out.println((i+1) + ".- " + ingredientes[i].getNombre() + ".");
        }
        System.out.println("=============================================");

        return leerEntero("Ingrese el numero del ingrediente que desea: ", ingredientes.length);
    }

    public static String menuTamaños() {
        String[] tamaños = {"Chico","Mediano","Grande"};
        return menuComplementos(tamaños, "tamaño");
    }
    
    public static String menuSalsa() {
        String[] salsas = {"Bufalo","BBQ"};
        return menuComplementos(salsas, "salsa");
    }
    
    public static String menuAderezo() {
        String[] aderezos = {"Ranch","Queso","Ketchup"};
        return menuComplementos(aderezos, "aderezo");
    }
    
    public static String menuSabor() {
        String[] sabores = {"Naranja","Fresa","Manzana"};
        return menuComplementos(sabores, "sabor");
    }

    public static String menuComplementos(String[] datos, String nombre) {
        System.out.println("=============================================");
        for(int i = 0; i<datos.length; i++){
            System.out.println((i + 1) + ".- " + datos[i]);
        }
        System.out.println("=============================================");

        int choose = leerEntero("Ingrese el numero de " + nombre + " que desea: ", datos.length);
        if(choose == 0) return null;

        return datos[choose - 1];
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

            input.nextLine();
            return num;
        } catch (InputMismatchException e) {
            input.nextLine();
            System.err.println("ERROR: Ingrese un numero entero valido o '0' para cancelar.");
            return leerEntero(msg, max);
        }
    }
}
