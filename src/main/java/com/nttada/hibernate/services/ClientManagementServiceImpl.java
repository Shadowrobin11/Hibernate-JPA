package com.nttada.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttadata.hibernate.persistence.ClientDaoI;
import com.nttadata.hibernate.persistence.ClientDaoImpl;
import com.nttadata.hibernate.persistence.Cliente;

/**
 * Trabajo - Hibernate - T1
 * 
 * Implementación del servicio de Cliente
 * 
 * @author Christian
 * 
 */

public class ClientManagementServiceImpl implements ClientManagementServiceI {
	
	/** DAO: Cliente*/
	private ClientDaoI clientDao;
	
	// Metodo constructor
	public ClientManagementServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}
	

	@Override
	public void insertNewCliente(Cliente newCliente) {
		
		// Verificación de null y la inexistencia
		if (newCliente != null && newCliente.getClienteID() == null) {

			// Insercción del nuevo Cliente
			clientDao.insert(newCliente);
		}
		
	}

	@Override
	public void updateCliente(Cliente newCliente) {
		// Verificación de nulidad y existencia
				
		if (newCliente != null &&  newCliente.getName() != null) {
			// Actualizacion del Cliente
			clientDao.update(newCliente);
		}
		
	}

	@Override
	public void deleteCliente(Cliente deletedCliente) {
		// Verificacion de null y existencia
		if (deletedCliente != null && deletedCliente.getName() != null) {
			
			// Eliminacion del Cliente.
			clientDao.delete(deletedCliente);
		}
		
	}

	@Override
	public List<Cliente> searchbyNameAndSecondName(String name, String priApellido, String segApellido) {
		List<Cliente> clientList;
		
		clientList = clientDao.searchByNameAndSecondName(name, priApellido, segApellido);
		return clientList;
	}

	
}
