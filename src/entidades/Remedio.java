package entidades;

public class Remedio {

	private int id;
	private String nome;
	private String laboratorio;
	private int volumeLiquido;
	private float peso;
	private int dose;
	
	public Remedio() {
		
	}
	
	public Remedio(String nome, String lab) {
		this.nome = nome;
		this.laboratorio = lab;
	}
	
	public Remedio(String nome, String lab, int vol, float peso, int dose) {
		this(nome, lab);
		this.volumeLiquido = vol;
		this.peso = peso;
		this.dose = dose;
	}
	
	public Remedio(int id,String nome, String lab, int vol, float peso, int dose) {
		this(nome, lab, vol, peso, dose);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getVolumeLiquido() {
		return volumeLiquido;
	}
	public void setVolumeLiquido(int volumeLiquido) {
		this.volumeLiquido = volumeLiquido;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	
}
