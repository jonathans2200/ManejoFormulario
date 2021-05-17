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
import manejoformulario.Dao.TelefonoDao;
import manejoformulario.model.Telefono;

/**
 *
 * @author jonat
 */
@WebServlet("/EliminarTelefono")
public class EliminarTelefonoController extends HttpServlet {
private TelefonoDao telefonoDao;
private Telefono telefono;
  public EliminarTelefonoController(){
      
  }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
}
