package entidades;

public class Medico extends Usuario {

	public Medico() {
		
	}
	
	public Medico(String login, String senha) {
		this.nivel = 2;
		this.login = login;
		this.senha = senha;
	}
	
	public Medico(int id, String login, String senha) {
		this(login, senha);
		this.id = id;
		this.nivel = 2;
	}
	
}
