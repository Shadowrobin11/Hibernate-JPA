package com.nttadata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Transient;

/**
 * Trabajo - Hibernate - T1
 * 
 * Entidad abstracta
 * 
 * @author Christian
 * 
 */

public abstract class AbstractEntity implements Serializable{

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;
	
	/** Auditoría | Usuario que actualiza */
	private String updatedUser;
	
	/** Auditoría | Día actualizado */
	private String updatedDate;
	
	/** Id General**/
	
	
	/**
	 * Get ID
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();
	
	
	/**
	 * @param updateUser 
	 * @return the updatedUser
	 * 
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser(String updateUser) {
		return updatedUser;
	}
	
	/**
	 * @param updatedUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updatedUser = updateUser;
	}
	
	/**
	 * @return the updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public String getUpdatedDate() {
		return updatedDate;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdatedDate(String updateDate) {
		this.updatedDate = updateDate;
	}
}
