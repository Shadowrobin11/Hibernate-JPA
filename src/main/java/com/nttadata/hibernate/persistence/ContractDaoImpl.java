package com.nttadata.hibernate.persistence;

import org.hibernate.Session;

/**
 * Trabajo - Hibernate - T1
 * 
 * Dao de tabla.
 * 
 * @author Christian
 * 
 */

public class ContractDaoImpl extends GeneralDaoImpl<Contract> implements ContractDaoI{
	
	// Conexión a base de datos
	private Session session;
	
	// Método constructor
	
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

}
