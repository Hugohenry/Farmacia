package servlets.Paciente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocios.NEPaciente;

/**
 * Servlet implementation class RemoverPaciente
 */
@WebServlet("/RemoverPaciente")
public class RemoverPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NEPaciente paciente;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverPaciente() {
        super();
        paciente = new NEPaciente();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		paciente.deletar(id);
		response.sendRedirect("ListarPaciente");
	}

}
