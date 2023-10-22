package conversorDeMoedas;

import java.util.Scanner;

public class ConversorMoedas {

    public static void main(String[] args) {

        double taxaDolar = 5.03;
        double taxaEuro = 5.33;
        double real = 1;
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o valor em real (ou 0 para sair): ");
            double valorReal = entrada.nextDouble();

            if (valorReal == 0) {
                System.out.println("Obrigado por usar o Conversor de Moedas. Até logo!");
                break;
            }

            System.out.println("Escolha uma opção para converter em Real:\n1. Dólar\n2. Euro");
            int opcao = entrada.nextInt();

            double resultado = 0;

            if (opcao == 1) {
                resultado = valorReal / taxaDolar;
                System.out.printf("A conversão de Real para Dólar é: R$%.2f%n", resultado);
            } else if (opcao == 2) {
                resultado = valorReal / taxaEuro;
                System.out.printf("A conversão de Real para Euro é: R$%.2f%n", resultado);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        entrada.close();
    }
}
