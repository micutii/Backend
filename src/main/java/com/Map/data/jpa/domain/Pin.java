
package com.Map.data.jpa.domain;

import javax.persistence.*;

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
}
