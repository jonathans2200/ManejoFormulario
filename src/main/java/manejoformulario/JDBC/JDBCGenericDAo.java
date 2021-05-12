/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.JDBC;

import manejoformulario.Dao.GenericDao;
import manejoformulario.utils.ConexionJDBC;


/**
 *
 * @author jonat
 */
public abstract class JDBCGenericDAo<T, ID> implements GenericDao<T, ID> {
 protected ConexionJDBC jdbc= ConexionJDBC.getJDBC();
}
