package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Paciente;

public class DAPaciente implements IDAPaciente {

	public int salvar(Paciente p) {
		int retorno = 0;
        try {
            Connection con = Conexao.getConnection();

            if(p.getId() == 0) {
                //Cria o preparedStatement
                String sql = "INSERT INTO PACIENTE (ID, NIVEL, LOGIN, SENHA, NOME, SOBRENOME, IDADE, SEXO) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);

                //Preenche os valores
                statement.setInt(1, 1);
                statement.setString(2, p.getLogin());
                statement.setString(3, p.getSenha());
                statement.setString(4, p.getNome());
                statement.setString(5, p.getSobrenome());
                statement.setFloat(6, p.getIdade());
                statement.setBoolean(7, p.isSexo());

                //Executa
                statement.execute();
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    retorno = rs.getInt(1);
                }

                statement.close();
            } else {
                // Cria o preparedStatement
                String sql = "UPDATE PACIENTE SET NIVEL = 1, LOGIN = ?, SENHA = ?, NOME = ?, SOBRENOME = ?, IDADE = ?, SEXO = ? WHERE ID = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                // Preenche os valores
                statement.setString(1, p.getLogin());
                statement.setString(2, p.getSenha());
                statement.setString(3, p.getNome());
                statement.setString(4, p.getSobrenome());
                statement.setFloat(5, p.getIdade());
                statement.setBoolean(6, p.isSexo());
                statement.setInt(7, p.getId());

                // Executa
                statement.execute(); // Executa a Consulta
                retorno = p.getId(); // Retorna o id do Objeto
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
            String sql = "DELETE FROM PACIENTE WHERE ID = ?";
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
	
	public Paciente get(int id) {
		Paciente retorno = null;
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM PACIENTE WHERE ID = (?)";
            PreparedStatement statement = con.prepareStatement(sql);

            // Preenche os valores
            statement.setInt(1, id);

            // Executa
            ResultSet r = statement.executeQuery();

            r.next();
            retorno = lerPaciente(r);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	public List<Paciente> list() {
		ArrayList<Paciente> retorno = new ArrayList<Paciente>();
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM PACIENTE";
            PreparedStatement statement = con.prepareStatement(sql);

            // Executa
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                retorno.add(lerPaciente(r));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	private Paciente lerPaciente(ResultSet r) throws SQLException {
		Paciente p = new Paciente();
		p.setId(r.getInt("id"));
		p.setNivel(r.getInt("nivel"));
		p.setLogin(r.getString("login"));
		p.setSenha(r.getString("senha"));
		p.setNome(r.getString("nome"));
		p.setSobrenome(r.getString("sobrenome"));
		p.setIdade(r.getInt("idade"));
		p.setSexo(r.getBoolean("sexo"));
		return p;
	}
	
}
