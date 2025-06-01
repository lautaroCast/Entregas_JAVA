package ej4;
//Se desea implementar una clase Almacen que
//pueda almacenar elementos de cualquier tipo
//que sean superclases de Producto. Esta clase
//debe tener un método para añadir elementos al
//almacén y otro método para imprimir los
//elementos almacenados.
//Implementa el método imprimirElementos de la
//clase Almacen utilizando un comodín <? super T>
//para permitir imprimir una lista de elementos sin
//importar el tipo específico.
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Almacen<Producto> almacen = new Almacen<>();

        almacen.agregarElemento(new Alimento("Pan", 2.5));
        almacen.agregarElemento(new Electronico("Notebook", 1200.0));

        List<Producto> productos = almacen.getElementos();

        System.out.println("Elementos en el almacén:");
        almacen.imprimirElementos(productos);  // Usa <? super T>
    }
}
