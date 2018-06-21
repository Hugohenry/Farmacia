package negocios;

import java.util.List;
import dados.DAMedico;
import entidades.Medico;

public class NEMedico implements INEMedico {
	
	private DAMedico rep;
	
	public NEMedico() {
		rep = new DAMedico();
	}
	
	public DAMedico getRepositorio() {
        return rep;
    }

    public void setRepositorio(DAMedico repositorio) {
        this.rep = repositorio;
    }

    @Override
    public int salvar(Medico m){
        if(m.getId()!= 0 && rep.get(m.getId()) == null) {
            throw new RuntimeException("Tentativa de ATUALIZAR um Paciente nao existente");
        }
        if(m.getLogin().length() < 5 || m.getLogin().length() > 25) {
            throw new RuntimeException("O LOGIN do Paciente deve ter entre 5 e 25 caracteres");
        }
        if(m.getLogin().length() < 6 || m.getLogin().length() > 20) {
            throw new RuntimeException("A SENHA do Paciente deve ter entre 6 e 20 caracteres");
        }
        int id = rep.salvar(m);
        return id;
    }

    @Override
    public void deletar(int id){
        rep.deletar(id);
    }

    @Override
    public Medico get(int id){
        return rep.get(id);
    }

    @Override
    public List<Medico> list(){
        return rep.list();
    }

}
