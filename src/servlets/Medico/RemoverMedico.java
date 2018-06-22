package servlets.Medico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocios.NEMedico;

/**
 * Servlet implementation class RemoverMedico
 */
@WebServlet("/RemoverMedico")
public class RemoverMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NEMedico medico;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverMedico() {
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
		medico.deletar(id);
		response.sendRedirect("ListarMedico");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
