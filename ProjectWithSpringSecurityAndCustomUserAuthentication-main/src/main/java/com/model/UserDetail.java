package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "student")
public class UserDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9080113325286923667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	// @NotBlank(message = "Please the User Name")
	@Column(name = "userid")
	private String userid;

	// @NotBlank(message = "Please enter the Password")
	@Column(name = "password")
	private String passwordString;

	@Column(name = "role")
	private String role;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the passwordString
	 */
	public String getPasswordString() {
		return passwordString;
	}

	/**
	 * @param passwordString the passwordString to set
	 */
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", userid=" + userid + ", passwordString=" + passwordString + ", role=" + role
				+ "]";
	}

}
