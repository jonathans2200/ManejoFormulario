/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class ConexionJDBC {

    private static final String Driver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/jee";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    private static ConexionJDBC jdbc = null;
    private Statement statement = null;

    public ConexionJDBC() {
        this.connect();
    }

    public static ConexionJDBC getJDBC() {
        if (jdbc == null) jdbc = new ConexionJDBC();
        

        return jdbc;

    }

    private void connect() {
        try {
            Class.forName(Driver);
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("PROBLEMAS CON EL DRIVER");
        } catch (SQLException e) {
            System.out.println("PROBLEMAS CON LA BD");

        }

    }

    public ResultSet query(String sql) {

        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException ex) {

            System.out.println("WARNIG>>>(JDBC:QUEY)" + sql + "----" + ex);
        }
        return null;

    }

    public Boolean update(String sql) {
        try {
            this.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("WARNIG>>>(JDBC:UPDATE) ACTUALIZACION" + sql + "----" + ex);
        }
        return true;

    }
}
