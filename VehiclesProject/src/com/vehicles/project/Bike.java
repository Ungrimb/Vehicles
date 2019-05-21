package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		//if (!rightWheel.equals(leftWheel))
		//	throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	@Override
	public String toString() {
		return "Bike [matrícula=" + plate + ", color=" + color + ", marca=" + brand + ", número de ruedas=" + wheels.size()  + "]";
	}

}
