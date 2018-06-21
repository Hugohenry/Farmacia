package negocios;

import java.util.List;
import dados.DAPaciente;
import entidades.Paciente;

public class NEPaciente implements INEPaciente {

private DAPaciente rep;
	
	public NEPaciente() {
		rep = new DAPaciente();
	}
	
	public DAPaciente getRepositorio() {
        return rep;
    }

    public void setRepositorio(DAPaciente repositorio) {
        this.rep = repositorio;
    }

    @Override
    public int salvar(Paciente p){
        if(p.getId()!= 0 && rep.get(p.getId()) == null) {
            throw new RuntimeException("Tentativa de ATUALIZAR um Paciente nao existente");
        }
        if(p.getLogin().length() < 5 || p.getLogin().length() > 25) {
            throw new RuntimeException("O LOGIN do Paciente deve ter entre 5 e 25 caracteres");
        }
        if(p.getLogin().length() < 6 || p.getLogin().length() > 20) {
            throw new RuntimeException("A SENHA do Paciente deve ter entre 6 e 20 caracteres");
        }
        if(p.getLogin().length() < 4 || p.getLogin().length() > 15) {
            throw new RuntimeException("O NOME do Paciente deve ter entre 4 e 15 caracteres");
        }
        if(p.getLogin().length() < 4 || p.getLogin().length() > 25) {
            throw new RuntimeException("O SOBRENOME do Paciente deve ter entre 4 e 25 caracteres");
        }
        if(p.getIdade() <= 0 || p.getIdade() > 115) {
        	throw new RuntimeException("A IDADE do Paciente deve estar entre 1 e 115 anos");
        }
        
        int id = rep.salvar(p);
        return id;
    }

    @Override
    public void deletar(int id){
        rep.deletar(id);
    }

    @Override
    public Paciente get(int id){
        return rep.get(id);
    }

    @Override
    public List<Paciente> list(){
        return rep.list();
    }
	
}
