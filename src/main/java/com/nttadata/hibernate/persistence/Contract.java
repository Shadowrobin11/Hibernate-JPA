package com.nttadata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * Trabajo - Hibernate - T1/T2
 * 
 * Clase Contract.
 * 
 * @author Christian
 * 
 */

@Entity
@Table(name = "NTTDATA_CONTRACT")
public class Contract extends AbstractEntity implements Serializable{

	// Serial Version.
	private static final long serialVersionUID = 1L;
	
	// Identificador Primary Key.
	private Long contractID;
	
	// Direccion del cliente.
	private String direction;
	
	// CP del cliente.
	private int cp;
	
	private Cliente client;
	
	/**
	 * 
	 * @return the ClientID
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractID() {
		return contractID;
	}
	
	/**
	 * @param contractID
	 *        the contractID to set
	 */
	public void setContractID(Long contractID) {
		this.contractID =  contractID;
	}
	
	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Column(name = "C_CP")
	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	@Column(name = "C_DIRECTION")
	public String getDirection() {
		return this.direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Transient
	@Override
	public Long getId() {
		return  this.contractID;
	}

	/**
	 *  @return the Client
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_FK", referencedColumnName = "CLIENT_ID")
	public Cliente getClient() {
		return this.client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}
	
	
	
}
