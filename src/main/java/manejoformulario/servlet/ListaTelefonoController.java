/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.PersonaDao;
import manejoformulario.Dao.TelefonoDao;
import manejoformulario.model.Persona;
import manejoformulario.model.Telefono;

/**
 *
 * @author jonat
 */
@WebServlet("/ListaTelefonoController")
public class ListaTelefonoController extends HttpServlet {
private TelefonoDao telefonoDao;
private List<Telefono> listaTelefono;
    public ListaTelefonoController(){
    telefonoDao=DAOFactory.getFactory().getTelefonoDao();
}
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       
            throws ServletException, IOException {
       String url= null;
      try {
			listaTelefono = telefonoDao.buscar();
			System.out.println("Tamaño de la lista recuperada: " + listaTelefono.size());
			request.setAttribute("personas", listaTelefono);
			url = "/PaginaPrincipal.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
