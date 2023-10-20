package agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaDeContatos {

	private ArrayList<Contato> contatos;
	
	//A classe mantém uma lista de contatos usando um ArrayList<Contato>.
	public AgendaDeContatos() {
		contatos = new ArrayList<>();
	}
	
	//Método para adicionar contatos na agenda
	public void adicionarContato(Contato contato) {
		contatos.add(contato);
	}
	
	//Método para listar todos os contatos da agenda
	public void listarContatos() {
		if(contatos.isEmpty()) {
			System.out.println("A agenda de contatos está vazia!");
		}else {
			System.out.println("Lista de contatos: ");
			for(Contato contato: contatos) {
				System.out.println(contato);
			}
		}
	}
	
	//Método para pesquisar os contatos pelo nome
	public Contato pesquisarContato(String nome) {
		for(Contato contato: contatos) {
			if(contato.getNome().equalsIgnoreCase(nome)) {
				return contato;
			}
		}
		return null;
	}
	
	//Método para remover um contato pelo nome
	public void removerContato(String nome) {
		for(Contato contato: contatos) {
			if(contato.getNome().equalsIgnoreCase(nome)) {
				contatos.remove(contato);
				System.out.println("Contato removido com sucesso!");
				return;
			}
		}
		System.out.println("Contato não encontrado!");
	}
	
	//Método para alterar contato pelo nome
	public void alterarContato(String nome, Contato novoContato) {
		for(int i = 0; i < contatos.size(); i++) {
			Contato contato = contatos.get(i);
			if(contato.getNome().equalsIgnoreCase(nome)) {
				contatos.set(i, novoContato);
				System.out.println("Contato alterado com sucesso!");
				return;
			}
		}
		System.out.println("Contato não encontrado.");
	}
	
	//O método main é o ponto de entrada do programa e é onde a interação do usuário ocorre.
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // Entrada de dados
		AgendaDeContatos agenda = new AgendaDeContatos();
		
		//O menu de opções que vai interagir com o usuário
		while(true) {
			System.out.println("\n Escolha uma opção: ");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Listar contato");
			System.out.println("3. Pesquisar contato");
			System.out.println("4. Remover contato");
			System.out.println("5. Alterar contato");
			System.out.println("6. Sair da agenda");
			
			int opcao = entrada.nextInt();
			entrada.nextLine();
			
			if(opcao == 1) {
				System.out.println("Nome do contato: ");
				String nome = entrada.nextLine();
				System.out.println("Telefone de contato: ");
				String telefone = entrada.nextLine();
				Contato novoContato = new Contato(nome, telefone);
				agenda.adicionarContato(novoContato);
				System.out.println("Contato adicionado com sucesso!");
			}else if(opcao == 2) {
				agenda.listarContatos();
			}else if(opcao == 3) {
				System.out.println("Digite o nome a ser pesquisado: ");
				String nome = entrada.nextLine();
				Contato contatoEncontrado = agenda.pesquisarContato(nome);
				if(contatoEncontrado != null) {
					System.out.println("Contato encontrado: \n" + contatoEncontrado);
				}else {
					System.out.println("Contato não encontrado.");
				}
			}else if(opcao == 4) {
				System.out.println("Digite o nome do contato a ser removido: ");
				String nome = entrada.nextLine();
				agenda.removerContato(nome);
			}else if(opcao == 5) {
				System.out.println("Digite o nome do contato a ser alterado: ");
				String nome = entrada.nextLine();
				
				Contato novoContato = new Contato("", "");
				System.out.print("Novo nome do contato: ");
				novoContato.setNome(entrada.nextLine());
				System.out.print("Novo telefone de contato: ");
				novoContato.setTelefone(entrada.nextLine());
				
				agenda.alterarContato(nome, novoContato);
			}else if(opcao == 6) {
				System.out.println("Encerrando a agenda de contatos.");
				break;
			}
		}
		
		entrada.close();
	}
}
