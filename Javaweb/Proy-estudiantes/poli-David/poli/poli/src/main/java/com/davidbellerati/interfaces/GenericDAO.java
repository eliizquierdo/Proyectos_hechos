/*
 * Descripcion -
 *  Interfaz para especificar los metodos necesarios de una clase DAO.
 *
 * Ultima modificacion -
 *   15/11/2025 8:12 p. m
 *
 * Autores -
 *   David Bellerati
 *   Natan Souza
*/

package com.davidbellerati.interfaces;

import java.util.List;
import com.davidbellerati.util.MySQLAdapter;
import java.sql.SQLException;

public interface GenericDAO<T> {

    /*
     * Consigue todas las instancias de la tabla correspondiente.
     * @return List<T> list
    */
    public List<T> getAll();

    /*
     * Devuelve una instancia de la tabla correspondiente mediante el id de la misma.
     * @return T t
    */
    public T getFromId(int id);

    /*
     * Permite agregar objetos a la tabla correspondiente.
     * @param T t
    */
    public void add(T t);

    /*
     * Permite remover objetos de la tabla correspondiente.
     * @param T t
    */
    public void remove(T t);

    /*
     * Permite actualizar objetos de la tabla correspondiente.
     * @param T t
    */
    public void update(T t);

}