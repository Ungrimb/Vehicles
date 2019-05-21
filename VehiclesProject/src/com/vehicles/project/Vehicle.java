package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	List<Vehicle> elements =new ArrayList<>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public Vehicle save(Vehicle vehicle){
		elements.add(vehicle);
		return vehicle;
	}

	public List<Vehicle> list(){
		return elements;
	}
}
