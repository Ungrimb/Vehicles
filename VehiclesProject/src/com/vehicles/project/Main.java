package com.vehicles.project;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        List<Vehicle> elements = new ArrayList<>();
        List<Wheel> wheels = new ArrayList<>();
        List<Wheel> frontWheels = new ArrayList<>();
        List<Wheel> backWheels = new ArrayList<>();

        String plate, brand, color, brWheel;
        Double dWheel;
        int ruedas,menuId=0;
        boolean menu=false;
        Pattern pat1 = Pattern.compile("^\\d{4}[A-Za-z]{3}");
        Pattern pat2 = Pattern.compile("^[A-Za-z]\\d{4}[A-Za-z]{2}");

        do {
            System.out.println("Introduce la matrícula:");
            plate = sc.nextLine();
            Matcher mat = pat1.matcher(plate);
            Matcher mat2 = pat2.matcher(plate);
            if (mat.matches()||mat2.matches()) {
                menuId=1;
            } else {
                System.out.println("Matrícula incorrecta");
            }
        } while (menuId==0);
        do {
            System.out.println("Introduce la marca:");
            brand = sc.nextLine();
            System.out.println("Introduce el color:");
            color = sc.nextLine();
            menuId=0;
        } while (menuId==1);
        do {
            System.out.println("Introduce 1 para Bike y 2 para Car:");
            ruedas = sc.nextInt();
            if (ruedas == 1 || ruedas == 2) {
            	ruedas = ruedas *2;
                for (int i = 0; i < ruedas; i++) {
                    do {
                        System.out.println("Introduce la marca de la rueda " + i + " :");
                        brWheel = sc.next();
                        if (brWheel.equals("")) {
                            System.out.println("Marca incorrecta");
                        } else menuId=1;
                    } while (menuId==0);
                    do {
                        System.out.println("Introduce el diametro de la rueda " + i + " :");
                        dWheel = sc.nextDouble();
                        menuId = Wheel.Diameter(dWheel);
                    } while (menuId==1);
                    if (ruedas == 2){
                        Wheel wheel = new Wheel(brWheel, dWheel);
                        wheels.add(wheel);
                    }
                    if (ruedas == 4){
                        if (i<2) {
                            Wheel frontWheel = new Wheel(brWheel, dWheel);
                            frontWheels.add(frontWheel);
                        } else {
                            Wheel backWheel = new Wheel(brWheel, dWheel);
                            backWheels.add(backWheel);
                        }
                    }
                    menu = true;
                }
            } else System.out.println("Número de ruedas incorrecto");
        } while (!menu);

        switch (ruedas){
            case 4:
                Car car = new Car(plate, brand, color);
                car.addWheels(frontWheels,backWheels);
                elements.add(car);
                break;
            case 2:
                Bike bike = new Bike(plate, brand, color);
                bike.addTwoWheels(wheels);
                elements.add(bike);
        }


        System.out.println(elements);
    }

}
