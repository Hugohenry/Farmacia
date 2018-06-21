package negocios;

import java.util.List;
import dados.DARemedio;
import entidades.Remedio;

public class NERemedio implements INERemedio {
	
	private DARemedio rep;
	
	public NERemedio() {
		rep = new DARemedio();
	}
	
	public DARemedio getRepositorio() {
        return rep;
    }

    public void setRepositorio(DARemedio repositorio) {
        this.rep = repositorio;
    }

    @Override
    public int salvar(Remedio r){
        if(r.getId()!= 0 && rep.get(r.getId()) == null) {
            throw new RuntimeException("Tentativa de ATUALIZAR um Remedio nao existente");
        }
        if(r.getNome().length() < 5 || r.getNome().length() > 100) {
            throw new RuntimeException("O NOME do Remedio deve ter entre 5 e 100 caracteres");
        }
        if(r.getLaboratorio().length() < 3 || r.getLaboratorio().length() > 30) {
            throw new RuntimeException("O NOME DO LABORATÓRIO do Remedio deve ter entre 3 e 30 caracteres");
        }
        
        int id = rep.salvar(r);
        return id;
    }

    @Override
    public void deletar(int id){
        rep.deletar(id);
    }

    @Override
    public Remedio get(int id){
        return rep.get(id);
    }

    @Override
    public List<Remedio> list(){
        return rep.list();
    }
	
}
