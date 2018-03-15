package com.company;

public class Car extends Vehicle {
    public Car(double x, double y, double price, double speed, int year) {
        super(x, y, price, speed, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", year=" + getYear() +
                '}';
    }
}
