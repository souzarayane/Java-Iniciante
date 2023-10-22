package jogoDaForca;

import java.util.Scanner;

public class JogoForca {
    public static void main(String[] args) {
        String palavraSugerida = "Java";
        int tentativas = 10;
        int tentativasRestantes = tentativas;
        
        System.out.println("Bem-vindo ao jogo da forca!");
        System.out.println("A dica é: uma linguagem de programação orientada a objetos");
        
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0) {
            System.out.print("Qual é a palavra secreta? ");
            String palavraDigitada = scanner.next();

            if (palavraSugerida.equalsIgnoreCase(palavraDigitada)) {
                System.out.println("Parabéns!!! Você acertou a palavra secreta!!!");
                break; // Encerra o jogo
            } else {
                System.out.println("Palavra errada, tente outra vez.");
                tentativasRestantes--;
                System.out.println("Tentativas restantes: " + tentativasRestantes);
            }
        }

        if (tentativasRestantes == 0) {
            System.out.println("Você ficou sem tentativas. A palavra secreta era: " + palavraSugerida);
        }

        scanner.close();
    }
}

