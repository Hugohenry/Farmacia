package dados;

import java.util.List;

import entidades.Pedido;

public interface IDAPedido {

	int salvar(Pedido p);
	void deletar(int id);
	Pedido get(int id);
	
	void aceitar(int id);
	void recuzar(int id);
	
	List<Pedido> list();
	List<Pedido> listByPaciente();
	
}
