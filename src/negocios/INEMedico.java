package negocios;

import java.util.List;

import entidades.Medico;

public interface INEMedico {
	
	int salvar(Medico m);
	void deletar(int id);
	Medico get(int id);
	
	List<Medico> list();

}
