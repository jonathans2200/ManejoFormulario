/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.TelefonoDao;
import manejoformulario.model.Telefono;

/**
 *
 * @author jonat
 */
@WebServlet("/ModificarTelefonoController")
public class ModificarTelefonoController extends HttpServlet {

    private TelefonoDao telefonoDao;
    private Telefono telefono;

    public ModificarTelefonoController() {
        telefonoDao = DAOFactory.getFactory().getTelefonoDao();
        telefono = new Telefono();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dato = Integer.parseInt(request.getParameter("codigo"));
        telefono = telefonoDao.read(dato);
        request.setAttribute("telefono", telefono);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModificarTelefono.jsp");
        dispatcher.forward(request, response);
        // TODO Auto-generated method stub
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String url = null;
        try {
            telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
            telefono.setNumero(request.getParameter("numero"));
            telefono.setTipo(request.getParameter("tipo"));
            telefono.setOperadora(request.getParameter("operador"));
            telefonoDao.update(telefono);   
           url = "/PaginaPrincipal.jsp";
        } catch (Exception e) {
            url="/error.jsp";
            System.out.println("error" + e.getMessage());
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
