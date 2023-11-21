package quizz;

import java.util.Scanner;

public class Quizz {
	
	private static String[] perguntas = {
            "1. Qual é o planeta mais próximo do sol?",
            "2. Quem é conhecido como o pai da Teoria da Relatividade?",
            "3. Qual a unidade de medida de energia no Sistema Internacional?",
            "4. Qual é o maior osso do corpo humano?",
            "5. Qual é o processo pelo qual as plantas produzem seu próprio alimento usando a luz solar?"
    };

    private static String[][] alternativas = {
            {"a)Terra", "b) Marte", "c) Vênus", "d)Júpter"},
            {"a)Isaac Newton", "b)Galileu Galilei", "c)Albert Einstein", "d)Stephen Hawking"},
            {"a)Joule", "b)Watt", "c)Caloria", "d)Volt"},
            {"a)Fêmur", "b)Tíbia", "c)Úmero", "d)Rádio"},
            {"a)Respiração", "b)Fotossíntese", "c)Digestão", "d)Transpiração"}
    };

    private static char[] respostas = {'c', 'b', 'c', 'b', 'a'};

    public static void apresentarPergunta(int numeroPergunta) {
        System.out.println(perguntas[numeroPergunta]);
        for (String alternativa : alternativas[numeroPergunta]) {
            System.out.println(alternativa);
        }
        System.out.print("Escolha a alternativa correta (a, b, c ou d): ");
    }

    public static void verificarResposta(char respostaUsuario, int numeroPergunta) {
        if (respostaUsuario == respostas[numeroPergunta]) {
            System.out.println("Resposta correta!");
        } else {
            System.out.println("Resposta incorreta. A resposta correta era: " + respostas[numeroPergunta]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int escolha = 1; // Iniciar com 1 para entrar no loop

        while (escolha != 0) {
            System.out.println("Bem-vindo(a) ao Quizz sobre ciências!"
                    + " Escolha 0 para sair ou 1 para jogar");
            escolha = scanner.nextInt();

            // Verificar se o usuário deseja jogar antes de entrar no loop do quiz
            if (escolha == 1) {
                for (int i = 0; i < perguntas.length; i++) {
                    apresentarPergunta(i);
                    char respostaUsuario = scanner.next().toLowerCase().charAt(0);
                    verificarResposta(respostaUsuario, i);
                }

                System.out.println("Fim do Quiz!");
            } else if (escolha != 0) {
                System.out.println("Opção inválida. Escolha 0 para sair ou 1 para jogar.");
            }
        }

        System.out.println("Obrigado por jogar!");

        scanner.close();
    }

}
