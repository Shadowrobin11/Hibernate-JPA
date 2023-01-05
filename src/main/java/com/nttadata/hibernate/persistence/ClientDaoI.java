package com.nttadata.hibernate.persistence;

import java.util.List;

/**
 * Trabajo - Hibernate - T1
 * 
 * Dao de la tabla cliente
 * 
 * @author Christian
 * 
 */

public interface ClientDaoI extends GeneralDaoI<Cliente> {

	/**
	 * obtiene clientes por nombre.
	 * 
	 * @param name
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByName(final String name);
	
	public List<Cliente> searchByNameAndSecondName(String name, String priApellido, String segApellido);
}
