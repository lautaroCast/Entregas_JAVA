package ej1;

public class clase1<T extends Number> implements Operable<T> {

        Integer n1 = 10;
        Integer n2 = 15;

    @Override
    public T sumar(T n1, T n2) {
        Integer resultado = n1.intValue() +n2.intValue();
        return (T) resultado;
    }

    @Override
    public T restar(T n1, T n2) {
        Integer resultado = n1.intValue() +n2.intValue();
        return (T)resultado;
    }

    @Override
    public T multiplicar(T n1, T n2) {
        Integer resultado = n1.intValue() +n2.intValue();
        return (T) resultado;
    }

    @Override
    public T dividir(T n1, T n2) {
        Float resultado = n1.floatValue() +n2.floatValue();
        return (T) resultado;
    }


}
