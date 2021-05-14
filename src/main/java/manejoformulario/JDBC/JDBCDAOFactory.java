/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.JDBC;

import manejoformulario.Dao.DAOFactory;
import manejoformulario.Dao.PersonaDao;
import manejoformulario.Dao.TelefonoDao;

/**
 *
 * @author jonat
 */
public class JDBCDAOFactory extends DAOFactory{

    @Override
    public void crearTablas(){
        this.getPersonaDao().crearTabla();
        this.getTelefonoDao().crearTabla();
    }
    
    @Override
    public PersonaDao getPersonaDao() {
    return new JDBCPersonaDao();
    }

    @Override
    public TelefonoDao getTelefonoDao() {
     return new JDBCTelefonoDao();
    }
    

}
