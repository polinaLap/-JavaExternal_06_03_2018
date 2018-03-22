package com.company;

public class VehicleFactory {
    private final int TYPE_VEHICLE = 5;
    private final int RANGE_X = 100;
    private final int RANGE_Y = 100;

    public Vehicle RandVehicle() {
        return GetVehicle((int)(Math.random()*TYPE_VEHICLE));
    }

    public Vehicle GetVehicle(int n) {
        switch (n) {
            case 0: return new Car(Math.random()*RANGE_X,Math.random()*RANGE_Y,Math.random()*1000,
                    Math.random()*200,2018-(int)(Math.random()*10));
            case 1: return new Plane(Math.random()*RANGE_X,Math.random()*RANGE_Y,Math.random()*1000,
                    Math.random()*500,2018-(int)(Math.random()*10),(int)(Math.random()*1000),(int)(Math.random()*1000));
            case 2: return new Ship(Math.random()*RANGE_X,Math.random()*RANGE_Y,Math.random()*1000,
                    Math.random()*300,2018-(int)(Math.random()*10),(int)(Math.random()*1000),"DefaultPort");
            case 3: return new Amfibia(Math.random()*RANGE_X,Math.random()*RANGE_Y,Math.random()*1000,
                    Math.random()*200,2018-(int)(Math.random()*10));
            case 4: return new BatMobile(Math.random()*RANGE_X,Math.random()*RANGE_Y,Math.random()*1000,
                    Math.random()*500,2018-(int)(Math.random()*10));
            default:{
                System.out.println("Enter Vehicle");
                return null;
            }
        }
    }
}
