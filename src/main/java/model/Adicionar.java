package model;

public class Adicionar implements Operacao {
    @Override
    public int operar(int value1, int value2) throws ArithmeticException {
        return value1 + value2;
    }

    @Override
    public Operacao clone() {
        try {
            return (Operacao) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar operação", e);
        }
    }
}
