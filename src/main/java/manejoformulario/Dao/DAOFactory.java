/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.Dao;

import manejoformulario.JDBC.JDBCDAOFactory;

/**
 *
 * @author jonat
 */
public abstract class DAOFactory {
    protected static DAOFactory factory = new JDBCDAOFactory();
    
  
    public static DAOFactory getFactory(){
        
       return factory;
    }
    
    public void crearTablas(){}
    public abstract PersonaDao getPersonaDao();
    public abstract TelefonoDao getTelefonoDao();
    
    
}
