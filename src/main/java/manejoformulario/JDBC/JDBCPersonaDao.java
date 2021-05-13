/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejoformulario.Dao.PersonaDao;
import manejoformulario.model.Persona;

/**
 *
 * @author jonat
 */
public class JDBCPersonaDao extends JDBCGenericDAo<Persona, Integer> implements PersonaDao {

    @Override
    public void crearTabla() {
        jdbc.update("DROP TABLE IF EXISTS Persona");
        jdbc.update("CREATE TABLE Persona\n"
                + "(cedula char NOT NULL,\n"
                + "    nombre char,\n"
                + "    apellido char,\n"
                + "    correo char NOT NULL,\n"
                + "    usuario char,\n"
                + "    contrasena char,\n"
                + "    CONSTRAINT Persona_pkey PRIMARY KEY (cedula));");
    }

    @Override
    public void crear(Persona entity) {
        jdbc.update("INSERT INTO Persona VALUES ('"
                + entity.getCedula() + "','"
                + entity.getNombre() + "','"
                + entity.getApellido() + "','"
                + entity.getCorreo() + "','"
                + entity.getUsuario() + "','"
                + entity.getContrasena() + "');");

    }

    @Override
    public Persona read(Integer id) {
        Persona p = null;
        ResultSet rs = jdbc.query("SELECT * FROM Persona WHERE cedula=" + id);

        try {
            if (rs != null && rs.next()) {
                p = new Persona();
            }
        } catch (SQLException ex) {
            System.out.println("READ " + ex.getMessage());
        }
        return p;
    }

    @Override
    public void update(Persona entity) {
        jdbc.update("UPDATE Persona SET  nombre='"
                + entity.getNombre() + "', apellido='"
                + entity.getApellido() + "', correo='"
                + entity.getCorreo() + "', usuario='"
                + entity.getUsuario() + "', contrasena='"
                + entity.getContrasena() + "' WHERE cedula='"
                + entity.getCedula() + "'");
    }

    @Override
    public void eliminar(Persona entity) {
        jdbc.update("DELETE FROM PERSONA WHERE cedula='"
                + entity.getCedula() + "'");
    }

    @Override
    public List<Persona> buscar() {
     
            List<Persona> lista= new ArrayList<Persona>();
            ResultSet rs=jdbc.query("SELECT * FROM PERSONA");
        try {
            while(rs.next()){
                lista.add(new Persona());
            }    } catch (SQLException ex) {
            System.out.println("Buscar"+ex.getMessage());
            }
    return lista;
    }

    @Override
    public boolean buscarPersona(String usuario, String contra) {
   boolean resultado = false;
        ResultSet rs=jdbc.query("SELECT * from public.\"Persona\" as a where a.usuario='admin' AND a.contrasena='admin'");
        System.out.println("el resultado es" + rs);
        try {
            if (rs != null && rs.next()) {
        return resultado= true;
            }
        } catch (SQLException ex) {
            System.out.println("READ " + ex.getMessage());
        return  resultado =false;
        }
        return resultado;
    }
    
    

}
