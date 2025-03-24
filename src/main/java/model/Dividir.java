package model;

public class Dividir implements Operacao{

    @Override
    public int operar(int value1, int value2) throws ArithmeticException {
        return value1/value2;
    }
}
