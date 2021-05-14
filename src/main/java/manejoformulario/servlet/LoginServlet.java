package manejoformulario.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.PersonaDao;
import manejoformulario.model.Persona;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PersonaDao persona;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        persona = DAOFactory.getFactory().getPersonaDao();

        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        Persona p = persona.buscarPersona(usuario, pass);
        if (usuario.equals(p.getUsuario()) && pass.equals(p.getContrasena())) {

            sesion.setAttribute("usuario", p.getUsuario());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PaginaPrincipal.jsp");
            dispatcher.forward(request, response);
//		
        } else {
            out.println("Username or Password incorrect");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            
            System.out.println("Datos Incorrectos");

        }
    }

}
