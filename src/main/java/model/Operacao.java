package model;

public interface Operacao extends Cloneable {
        public int operar(int value1, int value2) throws ArithmeticException;

        Operacao clone();
}
