/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.JDBC;

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

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jee?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static ConexionJDBC jdbc = null;
    private Statement statement = null;

    public ConexionJDBC() {
        this.connect();
    }

    public static ConexionJDBC getJDBC() {
        if (jdbc == null) {
            jdbc = new ConexionJDBC();
        }

        return jdbc;

    }

    public void connect() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println(">>>WARNING (JDBC:connect)...problemas con el driver\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBC:connect)...problemas con la BD\n" + e.getMessage());
        }
    }

    public ResultSet query(String sql) {
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBC:query): ---" + sql + "---" + e);
        }
        return null;
    }

    public boolean update(String sql) {
        try {
            this.statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBC:update)... actualizacion: ---" + sql + "---" + e);
            return false;
        }
    }

    protected static ConexionJDBC getJDBC1() {
        // creación de la conexión a la base de datos solo si no ha sido creada patrón
        // de diseño singleton
        if (jdbc == null) {
            jdbc = new ConexionJDBC();
        }
        return jdbc;

    }
}
