package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class VehicleArray {
    private Vehicle[] vehicles;
    private int count; //колво реальных элементов в массиве

    public VehicleArray(Vehicle[] vehicles) {
        this.vehicles=vehicles;
        count = vehicles.length;
    }
    public VehicleArray(int n){
        vehicles= new Vehicle[n];
        count=0;
    }
    public VehicleArray(){this(0);}
    public void Add(Vehicle newVeh){
        if(count>=vehicles.length) extend(1);
        vehicles[count++]=newVeh;
    }
    private void extend(int plusLength){
        Vehicle[] newVehicles = new Vehicle[vehicles.length+plusLength];
        for (int i = 0; i < vehicles.length; i++) {
           newVehicles[i]= vehicles[i];
        }
        vehicles = newVehicles;
    }
    public Vehicle getVehicle(int index){
        if(index>=count) return null;
        return vehicles[index];
    }
    public int length(){return count;}

    public void sortByPrice() {
        for (int i = 1; i <count ; i++) {
            int j=i;
            double x =vehicles[i].getPrice();
            Vehicle curVeh = vehicles[i];
            while(j>0&&vehicles[j-1].getPrice()<x){vehicles[j]=vehicles[j-1];j--;}
            vehicles[j]=curVeh;
        }
    }
    public void sortBySpeed() {
        Arrays.sort(vehicles);
    }
    private Vehicle getExtrSpeedVeh(int mode){ //1-max, -1-min
        double extrSpeed=-Double.MAX_VALUE*mode;
        Vehicle extrVeh=null;
        for (int i = 0; i <count; i++) {
            if(extrSpeed*mode<vehicles[i].getSpeed()*mode){
                extrSpeed=vehicles[i].getSpeed();
                extrVeh=vehicles[i];
            }
        }
        return extrVeh;
    }
    public Vehicle maxSpeedVeh(){
        return getExtrSpeedVeh(1);
    }
    public Vehicle minSpeedVeh(){
        return getExtrSpeedVeh(-1);
    }
}
