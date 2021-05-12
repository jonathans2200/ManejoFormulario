/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoformulario.Dao;

import java.util.List;

/**
 *
 * @author jonat
 */
public interface GenericDao<T,ID> {
    public void crearTabla();
    public void crear(T entity);
    public T read(ID id);
    public void update(T entity);
    public void eliminar(T entity);
    public List<T> buscar();
    
}
