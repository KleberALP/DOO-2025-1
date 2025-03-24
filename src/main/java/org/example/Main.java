package org.example;

import java.util.Scanner;

import exception.CalculadoraExceptionHandler;
import factory.Factory;
import model.Operacao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean primeiroAcesso = true;
        int valor1 = 0;
        int valor2 = 0;
        int resultado = 0;

        do {
            opcoes();
            opcao = lerInteiro(scanner, "Escolha uma opção válida:");

            // Se a opção for inválida, apenas exibe a mensagem e volta ao menu
            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida.\n");
                continue;
            }

            if (opcao != 0) {
                if (primeiroAcesso) {
                    valor1 = lerInteiro(scanner, "Informe o valor 1:");
                    valor2 = lerInteiro(scanner, "Informe o valor 2:");
                } else {
                    valor1 = resultado;
                    valor2 = lerInteiro(scanner, "Informe o valor:");
                }

                String operacaoStr = "";
                switch (opcao) {
                    case 1:
                        operacaoStr = "Adicionar";
                        break;
                    case 2:
                        operacaoStr = "Subtrair";
                        break;
                    case 3:
                        operacaoStr = "Multiplicar";
                        break;
                    case 4:
                        operacaoStr = "Dividir";
                        break;
                }

                Operacao operacao = Factory.factory(operacaoStr);
                if (operacao != null) {
                    try {
                        resultado = operacao.operar(valor1, valor2);
                        System.out.println("Resultado: " + resultado + "\n");
                        primeiroAcesso = false;
                    } catch (Exception e) {
                        CalculadoraExceptionHandler.tratarExcecao(e);
                    }
                }
            }
        } while (opcao != 0);

        System.out.println("Calculadora encerrada.");
        scanner.close();
    }

    public static void opcoes() {
        System.out.println("Informe a operação:");
        System.out.println("1. Somar");
        System.out.println("2. Subtrair");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("0. Encerrar calculadora");
    }

    public static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpa o valor inválido do buffer
            }
        }
    }
}
