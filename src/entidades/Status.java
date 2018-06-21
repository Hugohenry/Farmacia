package entidades;

public enum Status {
	
	PENDENTE("PENDENTE"), ACEITO("ACEITO"), RECUSADO("RECUSADO");
	
	private String desc;
	
	private Status(String desc) {
		this.desc = desc;
	}
	
	public String getDescricao() {
		return this.desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
