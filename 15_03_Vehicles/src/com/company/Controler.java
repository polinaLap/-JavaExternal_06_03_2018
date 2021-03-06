package com.company;

public class Controler {
    private static int curYear =2018;
    //Vehicle с наибольшей ценой
    public static Vehicle task1(VehicleArray vehicles) {
        double maxPrice = 0;
        Vehicle curVeh = null;
        for (int i = 0; i < vehicles.length(); i++) {
            if (vehicles.getVehicle(i).getPrice()> maxPrice) {
                maxPrice = vehicles.getVehicle(i).getPrice();
                curVeh = vehicles.getVehicle(i);
            }
        }
        return curVeh;
    }

    //механизм год выпуска 2000-2005 с  скоростью выше 150 км\ч, и наименьшей ценой
    public static Vehicle task2(VehicleArray vehicles) {
        double minPrice = Double.MAX_VALUE;
        Vehicle curVeh = null;
        for (int i = 0; i < vehicles.length(); i++) {
            if (vehicles.getVehicle(i).getYear() >= 2000 && vehicles.getVehicle(i).getYear() <= 2005
                    && vehicles.getVehicle(i).getSpeed() > 150
                    && vehicles.getVehicle(i).getPrice() < minPrice) {
                curVeh = vehicles.getVehicle(i);
                minPrice = vehicles.getVehicle(i).getPrice();
            }
        }
        return curVeh;
    }

    //Из Масива Vehicle получить масив Car не старше 5 лет
    public static VehicleArray task3(VehicleArray vehicles) {
        VehicleArray cars= new VehicleArray();
        for (int i = 0; i < vehicles.length(); i++) {
            if ("com.company.Car".equals(vehicles.getVehicle(i).getClass().getName())
                    &&curYear-vehicles.getVehicle(i).getYear()<=5){
                cars.Add(vehicles.getVehicle(i));
            }
        }
        return cars;
    }

    //Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию
    public static VehicleArray task4(VehicleArray  vehicles){
        VehicleArray ships = new VehicleArray();
        for (int i = 0; i < vehicles.length(); i++) {
            if ("com.company.Ship".equals(vehicles.getVehicle(i).getClass().getName())
                    &&curYear-vehicles.getVehicle(i).getYear()<=5){
                ships.Add(vehicles.getVehicle(i));
            }
        }
        ships.sortByPrice();
        return ships;
    }
    public static void print(VehicleArray vehicles, int mode){
        for (int i = 0; i <vehicles.length() ; i++) {
            System.out.println(vehicles.getVehicle(i).toString());
            if(mode!=0){
                if(vehicles.getVehicle(i) instanceof ISwim) {((ISwim)(vehicles.getVehicle(i))).swim();}
                else if(vehicles.getVehicle(i) instanceof IFly) { ((IFly)(vehicles.getVehicle(i))).fly();}
                else if(vehicles.getVehicle(i) instanceof IMove) { ((IMove)(vehicles.getVehicle(i))).move();}
            }
        }
    }

    public static VehicleArray[] sortByInterfaces(VehicleArray vehicles){
        VehicleArray [] res = new VehicleArray[3];
        res[0] = new VehicleArray();
        res[1] = new VehicleArray();
        res[2] = new VehicleArray();
        for (int i = 0; i <vehicles.length() ; i++) {
            if(vehicles.getVehicle(i) instanceof ISwim) { res[0].Add(vehicles.getVehicle(i));}
            else if(vehicles.getVehicle(i) instanceof IFly) { res[1].Add(vehicles.getVehicle(i));}
            else if(vehicles.getVehicle(i) instanceof IMove) { res[2].Add(vehicles.getVehicle(i));}
        }
        return res;
    }
}
