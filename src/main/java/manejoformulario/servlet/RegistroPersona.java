/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.PersonaDao;
import manejoformulario.model.Persona;

/**
 *
 * @author jonat
 */
@WebServlet("/RegistroPersona")
public class RegistroPersona extends HttpServlet {

    private PersonaDao personaDao;
    private Persona persona;

    public RegistroPersona() {
        personaDao = DAOFactory.getFactory().getPersonaDao();
        persona = new Persona();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;

        try {
            persona.setCedula(request.getParameter("cedula"));
            persona.setNombre(request.getParameter("nombre"));
            persona.setApellido(request.getParameter("apellido"));
            persona.setCorreo(request.getParameter("correo"));
            persona.setUsuario(request.getParameter("usuario"));
            persona.setContrasena(request.getParameter("contrasena"));
            personaDao.crear(persona);
            url = "/login.jsp";

        } catch (Exception e) {
            url = "/error.jsp";
        }
    getServletContext().getRequestDispatcher(url).forward(request, response);	
    }

}
