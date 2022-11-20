package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8169830116459045567L;

	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long addressid;

	@Column(name = "userid")
	long userid;

	@Column(name = "street")
	@NotBlank(message = "Please Enter the Street Number")
	String street;

	@Column(name = "city")
	@NotBlank(message = "Please Enter the city Name")
	String city;

	@Column(name = "country")
	@NotBlank(message = "Please Enter the country Name")
	String country;

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", userid=" + userid + ", street=" + street + ", city=" + city
				+ ", country=" + country + "]";
	}

	/**
	 * @return the addressid
	 */
	public long getAddressid() {
		return addressid;
	}

	/**
	 * @param addressid the addressid to set
	 */
	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
