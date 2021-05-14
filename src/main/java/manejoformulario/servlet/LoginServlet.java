package manejoformulario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.PersonaDao;
import manejoformulario.Dao.TelefonoDao;
import manejoformulario.model.Persona;
import manejoformulario.model.Telefono;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PersonaDao persona;
    private TelefonoDao telefonoDao;
    private List<Telefono> listaTelefono;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        persona = DAOFactory.getFactory().getPersonaDao();
        telefonoDao = DAOFactory.getFactory().getTelefonoDao();
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
        listaTelefono = telefonoDao.buscar();
        System.out.println("Tamaño de la lista recuperada: " + listaTelefono.size());

        Persona p = persona.buscarPersona(usuario, pass);
        if (usuario.equals(p.getUsuario()) && pass.equals(p.getContrasena())) {
            request.setAttribute("personas", listaTelefono);
            sesion.setAttribute("usuario", p);
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
