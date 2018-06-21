package servlets.Paciente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Paciente;
import negocios.NEPaciente;

/**
 * Servlet implementation class AtualizarPaciente
 */
@WebServlet("/AtualizarPaciente")
public class AtualizarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NEPaciente paciente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarPaciente() {
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
		request.setAttribute("paciente", paciente.get(id));
		request.getRequestDispatcher("atualizarPaciente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		String login = request.getParameter("login");
		String senha = request.getParameter("password");
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		int idade = Integer.valueOf(request.getParameter("idade"));
		boolean sexo;
		boolean sexoRadio = Boolean.valueOf(request.getParameter("sexo"));
		if(sexoRadio == true) {
			sexo = true;
		}else {
			sexo = false;
		}
		
		Paciente p = new Paciente(id, login, senha, nome, sobrenome, idade, sexo);
		paciente.salvar(p);
		response.sendRedirect("ListarPaciente");
	}

}
