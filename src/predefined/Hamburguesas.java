package predefined;

import producto.Ingrediente;

public interface Hamburguesas {
    Ingrediente[][] ingredientes = {
        Ingredientes.SENCILLA,
        Ingredientes.DOBLE,
        Ingredientes.HAMBURPIZZA,
        Ingredientes.CARNIVORA,
        Ingredientes.CHIKENBURGUER,
        Ingredientes.BBQ
    };

    String[] nombres = {
        "Sencilla",
        "Doble",
        "HamburPizza",
        "Carnivora",
        "Chicken Burguer",
        "BBQ"
    };

    double[] precios = {
        35,
        55,
        75,
        75,
        45,
        45
    };
}
