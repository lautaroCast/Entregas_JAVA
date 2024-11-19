public class Persona {
    String nombre;
    String genero;
    String nacionalidad;
    int edad;
    int dni;
    int nacimiento;


    Persona(String nombre,String genero,String nacionalidad,int edad,int dni,int nacimiento){
        this.nombre = nombre;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.dni = dni;
        this.nacimiento = nacimiento;
    }

    void Imprimir(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Género: "+genero);
        System.out.println("Nacionalidad "+nacionalidad);
        System.out.println("Edad: "+edad);
        System.out.println("DNI: "+dni);
        System.out.println("Año de nacimiento: "+nacimiento);
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Cosme Fulanito","Masculino","Argentina",19,4651231,2005);
        Persona persona2 = new Persona("Lionel Messi","Masculino","Argentina",35,3012351,1993);
        persona1.Imprimir();
        persona2.Imprimir();

    }


}
