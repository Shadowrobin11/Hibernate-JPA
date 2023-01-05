package com.nttadata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;


/**
 * Trabajo - Hibernate - T1
 * 
 * Dao general
 * 
 * @author Christian
 * 
 */

public abstract class GeneralDaoImpl<T extends AbstractEntity> implements GeneralDaoI<T>{
	
	/** Tipo de clase */
	private Class<T> entityClass;
	
	/** Sesión de conexión a la base de datos */
	private Session session;
	
	/**
	 * Método constructor
	 * 
	 * @param session
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public GeneralDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}
	
	public void insert(final T paramT ) {
		
		//Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		// Insercción.
				session.save(paramT);
				session.flush();

				// Commit.
				session.getTransaction().commit();
			}
	public void update(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	public void delete(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	public T searchById(final Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por Primary key.
		T result = session.get(this.entityClass, id);

		return result;

	}

	@SuppressWarnings("unchecked")
	public List<T> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}



	
	}
