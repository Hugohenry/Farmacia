package entidades;

public class Pedido {
	
	private int id;
	private int idPaciente;
	private Status status;
	private int idRemedio;
	
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
	
}
