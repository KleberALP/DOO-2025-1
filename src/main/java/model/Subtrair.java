package model;

public class Subtrair implements Operacao{

    @Override
    public int operar(int value1, int value2) throws ArithmeticException {
        return value1-value2;
    }

}
