package ej3;


import java.util.ArrayList;

public class Almacen<T> {
    ArrayList<T> listaAlmacen = new ArrayList<>();
    public Almacen() {
        listaAlmacen = new ArrayList<>();
    }

    public void agregarProducto(T producto){
        listaAlmacen.add((T) producto);
    }

    public void imprimirProductos(){
        System.out.println("Productos alamacenados:");
        for (int i=0;i<listaAlmacen.size();i++){
            System.out.println(listaAlmacen.get(i));
        }

    }



}
