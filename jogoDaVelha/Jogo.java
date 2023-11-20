package jogoDaVelha;

import java.util.Scanner;

public class Jogo {

    // Método para imprimir o tabuleiro
    public static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar se alguém ganhou
    public static boolean verificarVencedor(char[][] tabuleiro, char jogador) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                    (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }

        // Verifica diagonais
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
                (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inicia o Tabuleiro
        char[][] tabuleiro = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // Variável para controlar o jogador atual (X ou 0)
        char jogadorAtual = 'X';

        // Loop principal do jogo
        while (true) {
            // Imprime o tabuleiro
            imprimirTabuleiro(tabuleiro);

            // Solicita a entrada do jogador
            System.out.println("Jogador " + jogadorAtual + ", é sua vez. Informe a linha (0-2) e a coluna (0-2) separadas por espaço:");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            // Verifica se a posição está ocupada
            if (tabuleiro[linha][coluna] == ' ') {
                // Atualiza o tabuleiro
                tabuleiro[linha][coluna] = jogadorAtual;

                // Verifica se alguém ganhou
                if (verificarVencedor(tabuleiro, jogadorAtual)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + jogadorAtual + " venceu!!!");
                    break;
                }

                // Verifica se é um empate
                boolean empate = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (tabuleiro[i][j] == ' ') {
                            empate = false;
                            break;
                        }
                    }
                    if (!empate) {
                        break;
                    }
                }
                if (empate) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("O jogo terminou em empate!");
                    break;
                }

                // Troca para o próximo jogador
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Posição ocupada. Tente novamente.");
            }
        }

        scanner.close();
    }
}
