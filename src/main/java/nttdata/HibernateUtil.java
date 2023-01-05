package nttdata;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Trabajo - Hibernate - T1
 * 
 * Clase de configuración
 * 
 * @author Christian
 * 
 */

public class HibernateUtil {

	/** Factoría de sesiones */
	private static final SessionFactory sessionFactory;
	
	/**
	 * Constructor privado
	 */
	private HibernateUtil() {
		
	}
	
	/**
	 * Generacón de factoría de sesiones.
	 */
	static {
		try {
			// Generación de configuración.
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (final Exception e) {
			// Error de inicialización
			System.err.println("[ERROR] Configuración de Hibernate - " + e);
			throw new ExceptionInInitializerError();
		}
	}
	
	/**
	 * Retorna la factoría de sesiones
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
