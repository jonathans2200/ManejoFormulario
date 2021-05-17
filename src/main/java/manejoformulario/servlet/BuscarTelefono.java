/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/BuscarTelefono")
public class BuscarTelefono extends HttpServlet {

    private Persona persona;
    private PersonaDao personaDao;
    private List<Telefono> telefono;
    private TelefonoDao telefonoDao;

    public BuscarTelefono() {
       persona = new Persona();
       telefono = new ArrayList<Telefono>();
       personaDao=DAOFactory.getFactory().getPersonaDao();
       telefonoDao=DAOFactory.getFactory().getTelefonoDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        try {
            int id = Integer.valueOf(request.getParameter("buscar"));
            persona = personaDao.metodoBuscar(id);
            if(persona!=null){
            request.setAttribute("datos", persona);
          telefono=telefonoDao.buscarPorCedula(persona.getCedula());
            request.setAttribute("telefono", telefono);
          
            url = "/buscarPersona.jsp";
                
            }
            System.out.println("EL VALOR DE LA CEDULA ES" + id);
        } catch (Exception e) {
            url = "/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

}
