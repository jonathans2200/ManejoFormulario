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
import javax.xml.registry.infomodel.TelephoneNumber;
import manejoformulario.Dao.TelefonoDao;
import manejoformulario.model.Persona;
import manejoformulario.model.Telefono;

/**
 *
 * @author jonat
 */
public class JDBCTelefonoDao extends JDBCGenericDAo<Telefono, Integer> implements TelefonoDao {

    @Override
    public void crearTabla() {
        jdbc.update("DROP TABLE IF EXISTS Telefono");
        jdbc.update("CREATE TABLE Telefono(\n"
                + "    codigo numeric,\n"
                + "    numero char,\n"
                + "    operadora char,\n"
                + "    tipo char,\n"
                + "    persona_id char,\n"
                + "    CONSTRAINT cod_pk PRIMARY KEY (codigo),\n"
                + ");");

    }

    @Override
    public void crear(Telefono entity) {
        jdbc.update("INSERT INTO Telefono VALUES ('"
                + entity.getCodigo() + "','"
                + entity.getNumero() + "','"
                + entity.getOperadora() + "','"
                + entity.getTipo() + "','"
                + entity.getPersona().getCedula() + "');");
    }

    @Override
    public Telefono read(Integer id) {
        Telefono p = null;
        ResultSet rs = jdbc.query("SELECT * FROM Telefono WHERE codigo=" + id);
        try {
            if (rs != null && rs.next()) {
                p = new Telefono();
                Persona s = new Persona();
                p.setCodigo(rs.getInt("codigo"));
                p.setNumero(rs.getString("numero"));
                p.setOperadora(rs.getString("operador"));
                p.setTipo(rs.getString("tipo"));

                s.setCedula(rs.getString("cedula"));
                p.setPersona(s);

            }
        } catch (SQLException ex) {
            System.out.println("READ " + ex.getMessage());
        }
        return p;
    }

    @Override
    public void update(Telefono entity) {
        jdbc.update("UPDATE Telefono SET numero='"
                + entity.getNumero() + "',operador='"
                + entity.getOperadora() + "', tipo='"
                + entity.getTipo() + 
                 "' WHERE codigo="
                + entity.getCodigo() + ";");

    }

    @Override
    public void eliminar(Telefono entity) {
        jdbc.update("DELETE FROM PERSONA WHERE codigo='"
                + entity.getCodigo() + "'");
    }

    @Override
    public List<Telefono> buscar() {

        List<Telefono> lista = new ArrayList<Telefono>();
        ResultSet rs = jdbc.query("SELECT * FROM telefono");
        try {
            while (rs.next()) {
                Telefono t = new Telefono();
                t.setCodigo(rs.getInt("codigo"));
                t.setNumero(rs.getString("numero"));
                t.setTipo(rs.getString("tipo"));
                t.setOperadora(rs.getString("operador"));
                Persona p = new Persona();
                p.setCedula(rs.getString("persona_id"));
                t.setPersona(p);
                lista.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Buscar" + ex.getMessage());
        }
        return lista;
    }


    
    
     public List<Telefono> buscarPorCedula(String cedula) {

        List<Telefono> lista = new ArrayList<Telefono>();
        ResultSet rs = jdbc.query("SELECT * FROM telefono WHERE persona_id='"
                +cedula +"'");
        try {
            while (rs.next()) {
                Telefono t = new Telefono();
                t.setCodigo(rs.getInt("codigo"));
                t.setNumero(rs.getString("numero"));
                t.setTipo(rs.getString("tipo"));
                t.setOperadora(rs.getString("operador"));
                Persona p = new Persona();
                p.setCedula(rs.getString("persona_id"));
                t.setPersona(p);
                lista.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Buscar" + ex.getMessage());
        }
        return lista;
    }

public int numeroTelefono(){
    int resultado =0;
   
        ResultSet rs = jdbc.query("select count(*) as total from telefono ;");
       try{
           if(rs.next()){
             resultado=rs.getInt("total");
           }
    }catch(Exception e){
           System.out.println("ERROR COUNT" + e);
          
    }
    return resultado;
}
}
