package com.vehicles.project;

public class Wheel {
	private String brand;
	Double diameter;

	public Wheel(String brand,Double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	public static int Diameter(Double dWheel) {
		int output = 1;
		if (dWheel>0.4 && dWheel<4) {
            output=0;
        } else System.out.println("Diametro entre 0.4 y 4");
		return output;
		
	}
}
