package nttdata;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttada.hibernate.services.ClientManagementServiceI;
import com.nttada.hibernate.services.ClientManagementServiceImpl;
import com.nttadata.hibernate.persistence.Cliente;
import com.nttadata.hibernate.persistence.Contract;

/**
 * Trabajo - Hibernate - T1
 * 
 * Clase main
 * 
 * @author Christian
 * 
 */
public class App {
	/**
	 * Método principal
	 * 
	 * @param args
	 */

	// * LOGGER */
	private final static Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		
		LOG.info("INICIO SESIÓN");
		// Inicio de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		LOG.info("INICIALIZACIÓN DE SERVICIOS");
		// Inicialización de servicios
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);

		LOG.info("AUDITORÍA");
		// Auditoria.
		final String updateUser = "Christian";

		LOG.info("GENERACIÓN DE CLIENTES");
		// Generación de clientes.
		final Cliente cliente = new Cliente();
		cliente.setName("Juan");
		cliente.setPriApellido("Sanchez");
		cliente.setSegApellido("Martinez");

		LOG.info("GENERACIÓN DE CONTRATOS");
		// Generación de contratos
		final Contract contract1 = new Contract();

		contract1.setClient(cliente);
		contract1.setCp(41013);
		contract1.setDirection("C/miramelindos 2");
		contract1.setUpdatedDate("23/11/22");
		contract1.getUpdatedUser(updateUser);

		List<Contract> newContracts = new ArrayList<>();
		newContracts.add(contract1);

		cliente.setContracts(newContracts);
		clientService.insertNewCliente(cliente);

		LOG.info("CONSULTA CON JPA");
		// Consultas (JPA Criteria)
		List<Cliente> clients = clientService.searchbyNameAndSecondName("Juan", "Sanchez", "Martinez");

		for (final Cliente client : clients) {
			LOG.debug(client.getName() + "--" + client.getPriApellido() + "--" + client.getSegApellido());
		}

		LOG.info("CIERRE DE SESIÓN");
		// Cierre de sesión.
		session.close();
	}

}
