package com.nttadata.hibernate.persistence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import java.util.List;



/**
 * Trabajo - Hibernate - T1
 * 
 * Dao de cliente
 * 
 * @author Christian
 * 
 */

public class ClientDaoImpl extends GeneralDaoImpl<Cliente> implements ClientDaoI{
	
	// Sesion de la base de datos
	private Session session;
	
	/**
	 * Método constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Cliente> searchByName(String name) {
		// Verificación de sesión abierta.
				if (!session.getTransaction().isActive()) {
					session.getTransaction().begin();
				}

				// Localiza clientes en función del nombre.
				final List<Cliente> clientsList = session.createQuery("FROM Cliente WHERE name='" + name + "'").list();

				return clientsList;
	}

	@Override
	public List<Cliente> searchByNameAndSecondName(String name, String priApellido, String segApellido) {
		
		// Consulta.
				final CriteriaBuilder cb = session.getCriteriaBuilder();
				final CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);
				final Root<Cliente> rootP = cquery.from(Cliente.class);
				final Join<Cliente, Contract> cJoinC = rootP.join("contracts");

				// Where.
				final Predicate pr1 = cb.like(cJoinC.getParent().<String> get("name"), name);
				final Predicate pr2 = cb.like(cJoinC.getParent().<String> get("priApellido"), priApellido);
				
				// Consulta.
				cquery.select(rootP).where(cb.and(pr1,pr2));

				// Ordenación descendente (mayor a menor) de contratos.
				// cquery.orderBy(cb.desc(cJoinC.get("budget")));

				// Ejecución de consulta.
				final List<Cliente> results = session.createQuery(cquery).getResultList();

				return results;
	}

	

	
}
