package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Medico;

public class DAMedico implements IDAMedico {

	public int salvar(Medico m) {
		int retorno = 0;
        try {
            Connection con = Conexao.getConnection();

            if(m.getId() == 0) {
                //Cria o preparedStatement
                String sql = "INSERT INTO MEDICO (ID, NIVEL, LOGIN, SENHA) VALUES (NULL, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);

                //Preenche os valores
                statement.setInt(1, 2);
                statement.setString(2, m.getLogin());
                statement.setString(3, m.getSenha());

                //Executa
                statement.execute();
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    retorno = rs.getInt(1);
                }

                statement.close();
            } else {
                // Cria o preparedStatement
                String sql = "UPDATE MEDICO SET NIVEL = 2, LOGIN = ?, SENHA = ? WHERE ID = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                // Preenche os valores
                statement.setString(1, m.getLogin());
                statement.setString(2, m.getSenha());
                statement.setInt(3, m.getId());

                // Executa
                statement.execute(); // Executa a Consulta
                retorno = m.getId(); // Retorna o id do Objeto
                statement.close();
            }
            con.close(); // Fecha a conexão
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno; 
	}
	
	public void deletar(int id) {
		try {
            Connection con = Conexao.getConnection();

            // Cria um preparedStatement
            String sql = "DELETE FROM MEDICO WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);

            // Preenche os valores
            statement.setInt(1, id);

            // Executa
            statement.execute();

            statement.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public Medico get(int id) {
		Medico retorno = null;
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM MEDICO WHERE ID = (?)";
            PreparedStatement statement = con.prepareStatement(sql);

            // Preenche os valores
            statement.setInt(1, id);

            // Executa
            ResultSet r = statement.executeQuery();

            r.next();
            retorno = lerMedico(r);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	public List<Medico> list() {
		ArrayList<Medico> retorno = new ArrayList<Medico>();
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM MEDICO";
            PreparedStatement statement = con.prepareStatement(sql);

            // Executa
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                retorno.add(lerMedico(r));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	private Medico lerMedico(ResultSet r) throws SQLException {
		Medico m = new Medico();
		m.setId(r.getInt("id"));
		m.setNivel(r.getInt("nivel"));
		m.setLogin(r.getString("login"));
		m.setSenha(r.getString("senha"));
		return m;
	}
	
}
