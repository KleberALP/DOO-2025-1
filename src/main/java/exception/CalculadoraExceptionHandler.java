package exception;
public class CalculadoraExceptionHandler {
    public static void tratarExcecao(Exception e) {
        if (e instanceof ArithmeticException) {
            System.out.println("Erro: Tentativa de divisão por zero. Por favor, insira valores válidos.\n");
        } else {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage() + "\n");
        }
    }
}

