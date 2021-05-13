package manejoformulario.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.PersonaDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 public PersonaDao persona;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
             persona=DAOFactory.getFactory().getPersonaDao();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		           

		String usuario=request.getParameter("usuario");
		String pass=request.getParameter("pass");
		
		if (persona.buscarPersona(usuario, pass)==true ) {
                    System.out.println(persona.buscarPersona(usuario, pass));
			sesion.setAttribute("usuario", usuario);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PaginaPrincipal.jsp");
			dispatcher.forward(request, response);
//			System.out.println("Si");
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			System.out.println("Datos Incorrectos");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
