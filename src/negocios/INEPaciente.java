package negocios;

import java.util.List;

import entidades.Paciente;

public interface INEPaciente {

	int salvar(Paciente p);
	void deletar(int id);
	Paciente get(int id);
	
	List<Paciente> list();
	
}
