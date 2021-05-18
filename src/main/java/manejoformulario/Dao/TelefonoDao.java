/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.Dao;

import java.util.List;
import manejoformulario.model.Telefono;

/**
 *
 * @author jonat
 */
public interface TelefonoDao  extends GenericDao<Telefono, Integer>{
     public List<Telefono> buscarPorCedula(String cedula);
     public int numeroTelefono();
}
