package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Almacen {
    private static final String SEPARADOR = ", ";
    private static final File INVENTARIO = new File("files\\inventario.txt");
    private static final String[] TIPOS = {"Ingrediente", "Complemento"};

    public static Map<String, Integer> getIngredientes() {
        Map<String, Integer> map = new HashMap<>();
        search(0, TIPOS[0]).forEach(item -> map.put(item[1], Integer.parseInt(item[2])) );

        return map;
    }

    public static Map<String, Integer> getComplementos() {
        Map<String, Integer> map = new HashMap<>();
        search(0, TIPOS[1]).forEach(item -> map.put(item[1], Integer.parseInt(item[2])) );

        return map;
    }

    public static Map<String, Integer> getAlmacen() {
        Map<String, Integer> map = new HashMap<>();
        map.putAll(getIngredientes());
        map.putAll(getComplementos());

        return map;
    }

    public static void mostrar(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.printf("%-20s | %d%n", k, v));
    }

    // Util
    public static List<String[]> search(int columna, String dato) {
        List<String[]> lista = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(INVENTARIO));
            String line = br.readLine();

            while(line != null) {
                String columnas[] = line.split(SEPARADOR);
                line = br.readLine();

                if(columnas[columna].equalsIgnoreCase(dato))
                    lista.add(columnas);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        return lista;
    }
    
    public static void write(Map<String, Integer> map, String type, boolean conservar) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(INVENTARIO, conservar));

            map.forEach((k, v) -> {
                pw.println(type + SEPARADOR + k + SEPARADOR + v);
            });
            
            pw.close();
        } catch(IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static int getCantidad(String nombre) {
        try {
            String cantidad = search(1, nombre).get(0)[2];
            return Integer.parseInt(cantidad);
        } catch(Exception e) {
            return -1;
        }
    }

    public static void setCantidad(String nombre, int cantidad) {
        Map<String, Integer> ingredientes = getIngredientes();
        Map<String, Integer> complementos = getComplementos();
        
        if(ingredientes.containsKey(nombre))
            ingredientes.replace(nombre, cantidad);
        write(ingredientes, TIPOS[0], false);
        
        if(complementos.containsKey(nombre))
            complementos.replace(nombre, cantidad);
        
        write(complementos, TIPOS[1], true);
    }

    public static void agregarCantidad(String nombre, int cantidad) {
        Map<String, Integer> ingredientes = getIngredientes();
        Map<String, Integer> complementos = getComplementos();
        
        if(ingredientes.containsKey(nombre))
            ingredientes.replace(nombre, ingredientes.get(nombre) + cantidad);
        write(ingredientes, TIPOS[0], false);
        
        if(complementos.containsKey(nombre))
            complementos.replace(nombre, complementos.get(nombre) + cantidad);
        
        write(complementos, TIPOS[1], true);
    }

    public static void quitarCantidad(String nombre, int cantidad) {
        if(cantidad > 0) cantidad *= -1;
        
        agregarCantidad(nombre, cantidad); // Si le agregamos una cantidad negativa, se la restaremos
    }
}
