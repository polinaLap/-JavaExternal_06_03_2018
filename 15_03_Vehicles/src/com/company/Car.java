package com.company;

public class Car extends Vehicle implements IMove {

    private Helm helm;
    public Helm getHelm() { return helm; }
    public Car(double x, double y, double price, double speed, int year) {
        super(x, y, price, speed, year);
        if(year<2015) helm=Helm.LEFT_SIDE;
        else helm=Helm.RIGHT_SIDE;
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

    @Override
    public void move() {
        System.out.println("Car move");
    }

    public class Engine extends Vehicle.Engine{
        public Engine(int type){
            this.type=type;
            Car.this.setSpeed(Car.this.getSpeed()+10*type);
            Car.this.setPrice(Car.this.getPrice()+100*type);
        }
    }

    public static enum  Helm{
        LEFT_SIDE, RIGHT_SIDE;
    }
}
