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
                + entity.getPersona().getCedula() + "',"
                + ");");
    }

    @Override
    public Telefono read(Integer id) {
        Telefono p = null;
        ResultSet rs = jdbc.query("SELECT * FROM Telefono WHERE codigo=" + id);
        try {
            if (rs != null && rs.next()) {
                p = new Telefono();
            }
        } catch (SQLException ex) {
            System.out.println("READ " + ex.getMessage());
        }
        return p;
    }

    @Override
    public void update(Telefono entity) {
        jdbc.update("UPDATE Telefono SET numero='"
                + entity.getNumero() + "',operadora='"
                + entity.getOperadora() + "', tipo='"
                + entity.getTipo() + "',  persona_id='"
                + entity.getPersona().getCedula() + "' WHERE codigo="
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
        ResultSet rs = jdbc.query("SELECT * FROM TELEFONO");
        try {
            while (rs.next()) {
                lista.add(new Telefono());
            }
        } catch (SQLException ex) {
            System.out.println("Buscar" + ex.getMessage());
        }
        return lista;
    }

  

    @Override
    public Telefono buscarPersona(String usuario, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
