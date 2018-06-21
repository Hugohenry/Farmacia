package entidades;

public class Paciente extends Usuario {

	private String nome;
	private String sobrenome;
	private int idade;
	private boolean sexo;
	
	public Paciente() {
		
	}
	
	public Paciente(String login, String senha, String nome, String sobrenome, int idade, boolean sexo) {
		this.nivel = 1;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public Paciente(int id, String login, String senha, String nome, String sobrenome, int idade, boolean sexo) {
		this(login, senha, nome, sobrenome, idade, sexo);
		this.id = id;
		this.nivel = 1;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	
}
