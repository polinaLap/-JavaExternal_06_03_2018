package com.company;

public class Ship extends Vehicle {
    private int pasCount;
    private String port;

    public Ship(double x, double y, double price, double speed, int year, int pasCount, String port) {
        super(x, y, price, speed, year);
        this.pasCount=pasCount;
        this.port=port;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "pasCount=" + pasCount +
                ", port='" + port + '\'' +
                ", x=" + getX() +
                ", y=" + getY() +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", year=" + getYear() +
                '}';
    }

    public int getPasCount() {
        return pasCount;
    }

    public String getPort() {
        return port;
    }
}
