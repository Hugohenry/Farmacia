package servlets.Paciente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocios.NEPaciente;

/**
 * Servlet implementation class ListarPaciente
 */
@WebServlet("/ListarPaciente")
public class ListarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NEPaciente paciente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPaciente() {
        super();
        paciente = new NEPaciente();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("pacientes", paciente.list());
		request.getRequestDispatcher("listarPaciente.jsp").forward(request, response);
	}


}
