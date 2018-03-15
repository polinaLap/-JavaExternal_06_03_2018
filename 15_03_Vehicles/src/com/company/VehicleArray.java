package com.company;

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
    public VehicleArray(){this(5);}
    public void Add(Vehicle newVeh){
        if(count>=vehicles.length) extend(5);
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
}
