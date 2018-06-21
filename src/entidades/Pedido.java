package entidades;

public class Pedido {
	
	private int id;
	private int idPaciente;
	private Status status;
	private int idRemedio;
	// Variáveis de Consulta
	private String nomePaciente;
	private int idRem;
	private String remLab;
	private String remNome;
	private int remVol;
	private float remPeso;
	private int remDose;
	
	public Pedido() {
		
	}
	
	public Pedido(int idPac, Status status, int rem) {
		this.idPaciente = idPac;
		this.status = status;
		this.idRemedio = rem;
	}
	
	public Pedido(int id, int idPac, Status status, int rem) {
		this(idPac, status, rem);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getRemedio() {
		return idRemedio;
	}

	public void setRemedio(int remedio) {
		this.idRemedio = remedio;
	}

	public int getIdRemedio() {
		return idRemedio;
	}

	public void setIdRemedio(int idRemedio) {
		this.idRemedio = idRemedio;
	}
	
	/* GETTERS E SETTERS DE CONSULTA */
	
	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public int getIdRem() {
		return idRem;
	}

	public void setIdRem(int idRem) {
		this.idRem = idRem;
	}

	public String getRemLab() {
		return remLab;
	}

	public void setRemLab(String remLab) {
		this.remLab = remLab;
	}

	public String getRemNome() {
		return remNome;
	}

	public void setRemNome(String remNome) {
		this.remNome = remNome;
	}

	public int getRemVol() {
		return remVol;
	}

	public void setRemVol(int remVol) {
		this.remVol = remVol;
	}

	public float getRemPeso() {
		return remPeso;
	}

	public void setRemPeso(float remPeso) {
		this.remPeso = remPeso;
	}

	public int getRemDose() {
		return remDose;
	}

	public void setRemDose(int remDose) {
		this.remDose = remDose;
	}
	
}
