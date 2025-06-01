package ej2;
import java.util.NoSuchElementException;

// Clase genérica que representa una pila basada en un array
public class PilaArray<E> {
    // Array para guardar los elementos
    private E[] arrayGenerico;

    // Contador que indica cuántos elementos hay en la pila
    private int contador;

    // Constructor: recibe el tamaño máximo de la pila
    @SuppressWarnings("unchecked") // Evita el warning de casteo genérico
    public PilaArray(int capacidad) {
        arrayGenerico = (E[]) new Object[capacidad]; // Creamos el array genérico
        contador = 0; // Inicialmente la pila está vacía
    }

    // Verifica si la pila está vacía
    public boolean estaVacia() {
        return contador == 0;
    }

    // Añade un elemento a la pila si hay espacio
    public boolean añadir(E tipoE) {
        if (contador < arrayGenerico.length) {
            arrayGenerico[contador] = tipoE; // Guarda el elemento en la posición actual
            contador++; // Avanza el contador
            return true; // Se pudo añadir
        } else {
            System.out.println("El array está lleno. No se puede añadir.");
            return false; // No se pudo añadir porque está lleno
        }
    }

    // Devuelve el último elemento añadido sin eliminarlo
    public E primero() {
        if (estaVacia()) {
            // Si no hay elementos, lanzamos una excepción
            throw new NoSuchElementException("La pila está vacía.");
        }
        return arrayGenerico[contador - 1]; // Devuelve el elemento en el tope
    }

    // Extrae y devuelve el último elemento añadido
    public E extraer() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
        contador--; // Bajamos el contador (sacamos el elemento del tope)
        E elemento = arrayGenerico[contador]; // Guardamos el elemento a devolver
        arrayGenerico[contador] = null; // Limpiamos la referencia (buena práctica)
        return elemento; // Devolvemos el elemento extraído
    }

    // Devuelve una representación en texto de la pila
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pila: [");
        for (int i = 0; i < contador; i++) {
            sb.append(arrayGenerico[i]);
            if (i < contador - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
