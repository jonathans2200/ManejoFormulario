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
import manejoformulario.Dao.TelefonoDao;
import manejoformulario.model.Persona;
import manejoformulario.model.Telefono;

/**
 *
 * @author jonat
 */
@WebServlet("/NuevoTelefonoController")
public class NuevoTelefonoController extends HttpServlet {

    private TelefonoDao telefonoDao;
    private Telefono telefono;
    private Persona persona ;
  
    public NuevoTelefonoController(){
        telefonoDao=DAOFactory.getFactory().getTelefonoDao();
        telefono=new Telefono();
        persona= new Persona(); 
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
      
        String url=null;
        try{
           telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
           telefono.setNumero(request.getParameter("numero"));
           telefono.setOperadora(request.getParameter("operadora"));
           telefono.setTipo(request.getParameter("tipo"));
           persona.setCedula(request.getParameter("cedula"));
           telefono.setPersona(persona);
           url="/modificarPersona.html";
        }catch(Exception e){
            url="/error.jsp";
        }
     }

   
}
