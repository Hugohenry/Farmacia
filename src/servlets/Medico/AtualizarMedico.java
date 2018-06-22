package servlets.Medico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Medico;
import negocios.NEMedico;

/**
 * Servlet implementation class AtualizarMedico
 */
@WebServlet("/AtualizarMedico")
public class AtualizarMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NEMedico medico;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarMedico() {
        super();
        medico = new NEMedico();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("medico", medico.get(id));
		request.getRequestDispatcher("atualizarMedico.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		String login = request.getParameter("login");
		String senha = request.getParameter("password");
		Medico m = new Medico(id, login, senha);
		medico.salvar(m);
		response.sendRedirect("ListarMedico");
	}

}
