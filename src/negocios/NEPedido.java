package negocios;

import java.util.List;
import dados.DAPedido;
import entidades.Pedido;

public class NEPedido implements INEPedido {

	private DAPedido rep;
	
	public NEPedido() {
		rep = new DAPedido();
	}
	
	public DAPedido getRepositorio() {
        return rep;
    }

    public void setRepositorio(DAPedido repositorio) {
        this.rep = repositorio;
    }

    @Override
    public int salvar(Pedido p){
        if(p.getId()!= 0 && rep.get(p.getId()) == null) {
            throw new RuntimeException("Tentativa de ATUALIZAR um Pedido nao existente");
        }
        if(p.getRemedio() != 0 && rep.get(p.getId()) == null) {
            throw new RuntimeException("O ID do Remedio nao existe");
        }
        
        int id = rep.salvar(p);
        return id;
    }

    @Override
    public void deletar(int id){
        rep.deletar(id);
    }

    @Override
    public Pedido get(int id){
        return rep.get(id);
    }

    @Override
    public void aceitar(int id) {
    	rep.aceitar(id);
    }
    
    @Override
    public void recuzar(int id) {
    	rep.recuzar(id);
    }
    
    @Override
    public List<Pedido> list(){
        return rep.list();
    }
    
    @Override
    public List<Pedido> listByPaciente() {
    	return rep.listByPaciente();
    }
	
}
