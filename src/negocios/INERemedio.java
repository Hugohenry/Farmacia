package negocios;

import java.util.List;

import entidades.Remedio;

public interface INERemedio {

	int salvar(Remedio r);
	void deletar(int id);
	Remedio get(int id);
	
	List<Remedio> list();
	
}
