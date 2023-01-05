package com.nttadata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mysql.cj.xdevapi.Client;


/**
 * Trabajo - Hibernate - T1
 * 
 * Clase cliente
 * 
 * @author Christian
 *
 */

@Entity
@Table (name = "NTTDATA_CLIENT")
public class Cliente extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** ID (PK)*/
	private Long clienteID;
	
	/** Nombre del cliente */
	private String name;
	
	/** Primer apellido */
	private String priApellido;
	
	/** Segundo apellido */
	private String segApellido;

	
	/** contrato asociado */
	private List<Contract> contracts;

	
	/**
	 * @return the CLientId
	 */
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClienteID() {
		return clienteID;
	}
	
	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}

	/**
	 * @return name
	 */
	@Column(name = "NAME_CLIENT", nullable = false)
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return priApellido
	 */
	@Column(name = "PRI_APELLIDO_CLIENT", nullable = false)
	public String getPriApellido() {
		return priApellido;
	}
	
	/**
	 * @param priApellido
	 */
	
	public void setPriApellido(String priApellido) {
		this.priApellido = priApellido;
	}
	
	/**
	 * @return segApellido
	 */
	@Column(name = "SEG_APELLIDO_CLIENT", nullable = false)
	public String getSegApellido() {
		return segApellido;
	}
	
	/**
	 * @param segApellido
	 */
	
	public void setSegApellido(String segApellido) {
		this.segApellido = segApellido;
	}
	
	/**
	 * @return the contract
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	public List<Contract> getContracts() {
		return contracts;
	}
	
	/**
	 * @param contracts
	 *            the contracts to set
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	@Override
	public String toString() {
		return "Client [clientId =" + clienteID + ", name =" + name + ", PrimerApellido =" + priApellido + ", SegundoApellido	=" + segApellido  + "]";
	}
	
	@Transient
	public Class<?>getClase() {
		return Client.class;
	}
	
	@Transient
	public Long getId() {
		return this.clienteID;
	}
	
}
