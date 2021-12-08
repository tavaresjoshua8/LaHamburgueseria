package predefined;

import producto.Ingrediente;

public interface Ingredientes {
    Ingrediente CARNE = new Ingrediente("Carne" ,  8);
    Ingrediente PECHUGA = new Ingrediente("Pechuga" ,  9);
    Ingrediente TOMATE = new Ingrediente("Tomate" ,  2);
    Ingrediente PEPINILLO = new Ingrediente("Pepinillo" ,  1);
    Ingrediente LECHUGA = new Ingrediente("Lechuga" ,  1);
    Ingrediente CEBOLLA = new Ingrediente("Cebolla" ,  1);
    Ingrediente JALAPEÑO = new Ingrediente("Jalapeno" ,  1);
    Ingrediente QUESO_MANCHEGO = new Ingrediente("Queso Manchego" ,  5);
    Ingrediente QUESO_AMERICANO = new Ingrediente("Queso Americano" ,  4);
    Ingrediente JAMON = new Ingrediente("Jamon" ,  2);
    Ingrediente SALAMI = new Ingrediente("Salami" ,  3);
    Ingrediente PEPPERONI = new Ingrediente("Pepperoni" ,  4);
    Ingrediente TOCINO = new Ingrediente("Tocino" ,  4);
    Ingrediente SALSA_TOMATE = new Ingrediente("Salsa de Tomate" ,  3);
    Ingrediente SALSA_BBQ = new Ingrediente("Salsa de BBQ" ,  3);
    Ingrediente MAYONESA = new Ingrediente("Mayonesa" ,  1);
    Ingrediente MOSTAZA = new Ingrediente("Mostaza" ,  1);
    Ingrediente KETCHUP = new Ingrediente("Ketchup" ,  1);

    //* Ingredientes de cada pizza
    Ingrediente[] SENCILLA = { CARNE, TOMATE, PEPINILLO, LECHUGA, CEBOLLA, QUESO_AMERICANO, JAMON, MAYONESA, MOSTAZA, KETCHUP }; 
    Ingrediente[] DOBLE = { CARNE, CARNE, TOMATE, PEPINILLO, LECHUGA, CEBOLLA, QUESO_AMERICANO, QUESO_AMERICANO, JAMON, JAMON, MAYONESA, MOSTAZA, KETCHUP };
    Ingrediente[] HAMBURPIZZA = { CARNE, QUESO_MANCHEGO, PEPPERONI, SALSA_TOMATE }; 
    Ingrediente[] CARNIVORA = { CARNE, TOMATE, PEPINILLO, LECHUGA, CEBOLLA, QUESO_AMERICANO, JAMON, SALAMI, PEPPERONI, TOCINO, MAYONESA, MOSTAZA, KETCHUP };
    Ingrediente[] CHIKENBURGUER = { PECHUGA, TOMATE, PEPINILLO, LECHUGA, CEBOLLA, QUESO_AMERICANO, JAMON, MAYONESA, MOSTAZA, KETCHUP };
    Ingrediente[] BBQ = { CARNE, TOMATE, PEPINILLO, JALAPEÑO, LECHUGA, CEBOLLA, QUESO_AMERICANO, JAMON, SALSA_BBQ, MAYONESA, MOSTAZA, KETCHUP };

    //* Todos los ingredientes
    Ingrediente[] ingredientes = { CARNE, PECHUGA, TOMATE, PEPINILLO, LECHUGA, CEBOLLA, JALAPEÑO, QUESO_MANCHEGO, QUESO_AMERICANO, JAMON, SALAMI, PEPPERONI, TOCINO, SALSA_TOMATE, SALSA_BBQ, MAYONESA, MOSTAZA, KETCHUP };
}