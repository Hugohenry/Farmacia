package dados;

import java.util.List;

import entidades.Paciente;

public interface IDAPaciente {

	int salvar(Paciente p);
	void deletar(int id);
	Paciente get(int id);
	
	List<Paciente> list();
	
}
