
package com.Map.data.jpa.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Pin")
public class Pin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PIN")
	private int idPin;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "LAT")
	private double latitude;
	@Column(name = "LON")
	private double longitude;
	@Column(name = "ID_TYPE")
	private int idType;
	@Column(name = "CONTACT")
	private String contact;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PERCENTAGE")
	private String percentage;
	@Column(name = "STATE")
	private int state;
	@Column(name = "NAME")
	private String name;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PROJECTS_FOR_WOMEN")
	private String projForWomen;
	@Column(name = "BENEFITS_FOR_WOMEN")
	private String benefitsForWomen;
	@Column(name = "MEMBERS")
	private int members;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdPin() {
		return idPin;
	}

	public void setIdPin(int idPin) {
		this.idPin = idPin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProjForWomen() {
		return projForWomen;
	}

	public void setProjForWomen(String projForWomen) {
		this.projForWomen = projForWomen;
	}

	public String getBenefitsForWomen() {
		return benefitsForWomen;
	}

	public void setBenefitsForWomen(String benefitsForWomen) {
		this.benefitsForWomen = benefitsForWomen;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}
}
