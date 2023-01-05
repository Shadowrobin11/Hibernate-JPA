package com.nttadata.hibernate.persistence;

import java.util.List;

/**
 * Trabajo - Hibernate - T1
 * 
 * Dao general
 * 
 * @author Christian
 * 
 */

public interface GeneralDaoI<T> {

	/**
	 * Inserta un registro en la base de datos
	 *  
	 *  @param paramT
	 */
	
	public void insert(final T paramT);
	
	/**
	 * Actualiza un registro en la base de datos
	 * @param paramT
	 */
	
	public void update(final T paramT);
	
	/**
	 * Elimina un registro en la base de datos
	 * @param paramT
	 */
	public void delete (final T paramT);
	
	/**
	 * Localiza un registro en la base de datos
	 * @param paramT
	 */
	public T searchById(final Long id);
	
	/**
	 * Búsqueda de todos los registros en la base de datos
	 * @return List<T>
	 */
	public List<T> searchAll();
}
