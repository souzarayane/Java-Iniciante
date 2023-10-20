package agenda;

// Criando a classe Contato com um nome e um telefone
public class Contato {
	
	private String nome;
	private String telefone;
	
	// Método construtor que cria objetos de contato com nome e telefone
	public Contato(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getNome() { //permitem acessar o nome do contato.
		return nome;
	}
	
	public String getTelefone() { //permitem acessar o telefone do contato.
		return telefone;
	}
	
	public String toString() { // é anulado para retornar uma representação em string do contato
		return "Nome: " + nome + ", Telefone: " + telefone;
	}

	//Este método é usado para definir ou alterar o número de telefone de um contato
	public void setTelefone(String nextLine) {//
		// TODO Auto-generated method stub
		
	}
    
	//Este método é usado para definir ou alterar o nome de um contato
	public void setNome(String nextLine) {
		// TODO Auto-generated method stub
		
	}
}


