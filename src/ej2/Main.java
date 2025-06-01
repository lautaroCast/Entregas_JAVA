package ej2;

public class Main {
    public static void main(String[] args) {
        PilaArray<String> pila = new PilaArray<>(3);

        // Verificar si está vacía
        System.out.println("¿La pila está vacía? " + pila.estaVacia());

        // Añado elementos
        System.out.println("\nAñadiendo elementos:");
        System.out.println("Añadir 'Uno': " + pila.añadir("Uno"));
        System.out.println("Añadir 'Dos': " + pila.añadir("Dos"));
        System.out.println("Añadir 'Tres': " + pila.añadir("Tres"));

        // Intentamos añadir uno más (no debería poder)
        System.out.println("Añadir 'Cuatro': " + pila.añadir("Cuatro")); // debería devolver false

        // Mostrar pila actual
        System.out.println("\nEstado actual de la pila:");
        System.out.println(pila);

        // Obtengo el último elemento sin sacarlo
        System.out.println("\nElemento en la cima (primero): " + pila.primero());

        // Extraigo un elemento
        System.out.println("\nExtrayendo elemento: " + pila.extraer());

        // Mostrar pila después de extraer
        System.out.println("Pila después de extraer:");
        System.out.println(pila);

        // Extraigo los otros dos
        System.out.println("Extrayendo elemento: " + pila.extraer());
        System.out.println("Extrayendo elemento: " + pila.extraer());

        // Ahora la pila debería estar vacía
        System.out.println("\n¿La pila está vacía? " + pila.estaVacia());

        // Intento extraer de nuevo (debería lanzar excepción)
        try {
            System.out.println("Intentando extraer de pila vacía:");
            pila.extraer();
        } catch (Exception e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}

