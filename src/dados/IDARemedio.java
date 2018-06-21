package dados;

import java.util.List;

import entidades.Remedio;

public interface IDARemedio {

	int salvar(Remedio r);
	void deletar(int id);
	Remedio get(int id);
	
	List<Remedio> list();
	
}
