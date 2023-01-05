package com.nttada.hibernate.services;


import java.util.List;

import com.nttadata.hibernate.persistence.Cliente;

/**
 * Trabajo - Hibernate - T1
 * 
 * Interface del servicio cliente.
 * 
 * @author Christian
 * 
 */

public interface ClientManagementServiceI {

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newCliente
	 */
	public void insertNewCliente(final Cliente newCliente);
	
	/**
	 * Actualiza un Cliente existente
	 * 
	 * @param updateCliente
	 */
	public void updateCliente(final Cliente newCliente);
	
	/**
	 * Elimina un Cliente existente
	 * 
	 * @param deleteCliente
	 */
	public void deleteCliente(final Cliente deletedCliente);
	
	/**
	 * Obtiene el nombre y apellidos de Cliente
	 * 
	 * @param name
	 * @param priApellido
	 * @param segApellido
	 */
	public List<Cliente> searchbyNameAndSecondName(final String name, String priApellido, String segApellido);
}
