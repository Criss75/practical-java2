package com.course.practicaljava2.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "color", "serialNumber" })
public class Engine {

	private String fuelType;
	private int horsePower;
	private String color;
	private String serialNumber;

	public Engine() {

	}

	public Engine(String fuelType, int horsePower) {
		super();
		this.fuelType = fuelType;
		this.horsePower = horsePower;
	}

	public String getColor() {
		return color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Engine [fuelType=" + fuelType + ", horsePower=" + horsePower + "]";
	}

}