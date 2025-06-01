package ej3;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen<>();

        Alimentos a1 = new Alimentos("PIZZA",10500);
        Electronicos e1 = new Electronicos("NoteBook",12000.00);
        Indumentaria i1 = new Indumentaria("Camiseta 10",8000);

        almacen.agregarProducto(a1);
        almacen.agregarProducto(e1);
        almacen.agregarProducto(i1);

        almacen.imprimirProductos();
    }
}
