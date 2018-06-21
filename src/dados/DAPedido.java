package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Pedido;

public class DAPedido implements IDAPedido {

	public int salvar(Pedido p) {
		int retorno = 0;
        try {
            Connection con = Conexao.getConnection();

            if(p.getId() == 0) {
                //Cria o preparedStatement
                String sql = "INSERT INTO PEDIDO (ID, ID_PACIENTE, STATUS, ID_REMEDIO) VALUES (NULL, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);

                //Preenche os valores
                statement.setInt(1, p.getIdPaciente());
                statement.setString(2, p.getStatus().name());
                statement.setInt(3, p.getRemedio());

                //Executa
                statement.execute();
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    retorno = rs.getInt(1);
                }

                statement.close();
            } else {
                // Cria o preparedStatement
                String sql = "UPDATE PEDIDO SET ID_PACIENTE = ?, STATUS = ?, ID_REMEDIO = ? WHERE ID = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                // Preenche os valores
                statement.setInt(1, p.getIdPaciente());
                statement.setString(2, p.getStatus().name());
                statement.setInt(3, p.getRemedio());
                statement.setInt(4, p.getId());

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
            String sql = "DELETE FROM PEDIDO WHERE ID = ?";
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
	
	public Pedido get(int id) {
		Pedido retorno = null;
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM PEDIDO WHERE ID = (?)";
            PreparedStatement statement = con.prepareStatement(sql);

            // Preenche os valores
            statement.setInt(1, id);

            // Executa
            ResultSet r = statement.executeQuery();

            r.next();
            retorno = lerPedido(r);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	public void aceitar(int id) {
		
	}
	
	public void recuzar(int id) {
		
	}
	
	public List<Pedido> list() {
		ArrayList<Pedido> retorno = new ArrayList<Pedido>();
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT * FROM PEDIDO";
            PreparedStatement statement = con.prepareStatement(sql);

            // Executa
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                retorno.add(lerPedido(r));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	public List<Pedido> listByPaciente() {
		ArrayList<Pedido> retorno = new ArrayList<Pedido>();
        try {
            Connection con = Conexao.getConnection();

            // Cria o preparedStatement
            String sql = "SELECT PACIENTE.NOME \"nomePaciente\", PEDIDO.*, REMEDIO.* FROM PACIENTE INNER JOIN PEDIDO ON PACIENTE.ID = PEDIDO.ID_PACIENTE INNER JOIN REMEDIO ON RAMEDIO.ID = PEDIDO.ID_REMEDIO";
            PreparedStatement statement = con.prepareStatement(sql);

            // Executa
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                retorno.add(lerPedido(r));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
	}
	
	private Pedido lerPedido(ResultSet r) throws SQLException {
		Pedido p = new Pedido();
		p.setId(r.getInt("id"));
		p.setIdPaciente(r.getInt("id_paciente"));
		p.setStatus(r.getString("status"));
		p.setRemedio(r.getInt("id_remedio"));
		return p;
	}
	
}
