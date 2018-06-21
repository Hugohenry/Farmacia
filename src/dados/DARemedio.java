package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Remedio;

public class DARemedio implements IDARemedio {

	public int salvar(Remedio rem) {
		int retorno = 0;
        try {
            Connection con = Conexao.getConnection();

            if(rem.getId() == 0) {
                //Cria o preparedStatement
                String sql = "INSERT INTO REMEDIO (ID, NOME, LABORATORIO, VOLUME_LIQUIDO, PESO, DOSE) VALUES (NULL, ?, ?, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);

                //Preenche os valores
                statement.setString(1, rem.getNome());
                statement.setString(2, rem.getLaboratorio());
                statement.setInt(3, rem.getVolumeLiquido());
                statement.setFloat(4, rem.getPeso());
                statement.setInt(5, rem.getDose());

                //Executa
                statement.execute();
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    retorno = rs.getInt(1);
                }

                statement.close();
            } else {
                // Cria o preparedStatement
                String sql = "UPDATE REMEDIO SET NOME = ?, LABORATORIO = ?, VOLUME_LIQUIDO = ?, PESO = ?, DOSE = ? WHERE ID = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                // Preenche os valores
                statement.setString(1, rem.getNome());
                statement.setString(2, rem.getLaboratorio());
                statement.setInt(3, rem.getVolumeLiquido());
                statement.setFloat(4, rem.getPeso());
                statement.setInt(5, rem.getDose());
                statement.setInt(6, rem.getId());

                // Executa
                statement.execute(); // Executa a Consulta
                retorno = rem.getId(); // Retorna o id do Objeto
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
            String sql = "DELETE FROM REMEDIO WHERE ID = ?";
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
	
	public Remedio get(int id) {
		Remedio retorno = null;
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM REMEDIO WHERE ID = (?)";
            PreparedStatement statement = con.prepareStatement(sql);

            // Preenche os valores
            statement.setInt(1, id);

            // Executa
            ResultSet r = statement.executeQuery();

            r.next();
            retorno = lerRemedio(r);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	public List<Remedio> list() {
		ArrayList<Remedio> retorno = new ArrayList<Remedio>();
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM REMEDIO";
            PreparedStatement statement = con.prepareStatement(sql);

            // Executa
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                retorno.add(lerRemedio(r));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	private Remedio lerRemedio(ResultSet r) throws SQLException {
		Remedio rem = new Remedio();
		rem.setId(r.getInt("id"));
		rem.setNome(r.getString("nome"));
		rem.setLaboratorio(r.getString("laboratorio"));
		rem.setVolumeLiquido(r.getInt("volume_liquido"));
		rem.setPeso(r.getFloat("peso"));
		rem.setDose(r.getInt("dose"));
		return rem;
	}
	
}
