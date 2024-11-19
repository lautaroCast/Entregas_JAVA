public class Planeta {
    public enum Tipo {
        GASEOSO,TERRESTRE,ENANO
    }

    String nombre = null;
    int cantidad_satelites = 0;
    double masa = 0; //En kg
    double volumen = 0; //En Km
    int diametro = 0; //En Km
    int distacia_sol = 0; //En millones de Km
    Boolean observable = false;
    Tipo tipo;
    double orbital = 0;
    double rotacion = 0;

    Planeta(String nombre,int cantidad_satelites,double masa,double volumen,int diametro,int distacia_sol,boolean observable,Tipo tipo,double orbital,double rotacion) {
        this.nombre = nombre;
        this.cantidad_satelites = cantidad_satelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distacia_sol = distacia_sol;
        this.observable = observable;
        this.tipo = tipo;
        this.orbital = orbital;
        this. rotacion = rotacion;
    }

    void imprimir(){
        System.out.println("Planeta: "+nombre);
        System.out.println("Cantidad de satélites: "+cantidad_satelites);
        System.out.println("Masa: "+masa);
        System.out.println("Volumen: "+volumen);
        System.out.println("Diámetro: "+diametro);
        System.out.println("Distancia media al Sol: "+distacia_sol);
        System.out.println("Es observable: "+observable);
        System.out.println("Tipo de planeta: "+tipo);
        System.out.println("Periodo Orbital (AÑOS): "+orbital);
        System.out.println("Periodo de Rotación (Días): "+rotacion);
    }
    void calcular_densidad(double masa,double volumen){
        double densidad;
        densidad = masa / volumen;
        System.out.println("Densidad del planeta: "+densidad);
    }
    void exterior_interior(int distacia_sol){
        String resultado;
        if(distacia_sol < (149597870*2.1)){
            resultado = "Interior";
        }else if (distacia_sol > (149597870*3.4)){
            resultado = "Exterior";
        }else {
            resultado = "El planeta se encuentra en el cinturón de asteroides";
        }
        System.out.println("Considerado: "+resultado);
    }

    public static void main(String[] args) {
        Planeta p1 = new Planeta("Tierra",1,5.9736E24,1.08321E12,12742,150000000,true,Tipo.TERRESTRE,365.25,1);
        Planeta p2 = new Planeta("Júpiter",1,1.899E27,1.4313E15,139820,750000000,true,Tipo.GASEOSO,11.86,0.4);
        p1.imprimir();
        p1.calcular_densidad(p1.masa, p1.volumen);
        p1.exterior_interior(p1.distacia_sol);
        System.out.println("------------------------------------------");
        p2.imprimir();
        p2.calcular_densidad(p2.masa, p2.volumen);
        p2.exterior_interior(p2.distacia_sol);
    }

}
