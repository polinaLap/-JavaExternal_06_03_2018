package com.company;

public class Main {

        static  void testSortInterfaces(){
                int n=10;
                VehicleArray arr = new VehicleArray(n);
                VehicleFactory factory = new VehicleFactory();
                for (int i = 0; i < n; i++) {
                        arr.Add(factory.RandVehicle());
                }
                VehicleArray[] groups =  Controler.sortByInterfaces(arr);
                System.out.println();
                System.out.println("Vehicles devided on 3 groups");
                Controler.print(groups[0],1);
                Controler.print(groups[1],1);
                Controler.print(groups[2],1);
                System.out.println();
                System.out.println("Sorted by speed groups");
                groups[0].sortBySpeed();
                Controler.print(groups[0],0);
                groups[1].sortBySpeed();
                Controler.print(groups[1],0);
                groups[2].sortBySpeed();
                Controler.print(groups[2],0);
                System.out.println();
                System.out.println("Swimable vehicles with max and min speed");
                System.out.println(groups[0].maxSpeedVeh());
                System.out.println(groups[0].minSpeedVeh());
        }
        static void testDetails(){
                VehicleFactory factory = new VehicleFactory();
                Car car = (Car)factory.GetVehicle(0);
                System.out.println(car);
                car.new Engine(3);
                System.out.println(car);
                System.out.println("Type of helm "+car.getHelm());

                Plane plane = (Plane)factory.GetVehicle(1);
                System.out.println(plane);
                plane.new Engine(3);
                System.out.println(plane);
                System.out.println("Type of tail "+plane.getTail());

                Ship ship = (Ship)factory.GetVehicle(2);
                System.out.println(ship);
                ship.new Engine(3);
                System.out.println(ship);
                System.out.println("Type of screws "+ship.getScrews());

                Amfibia amfibia = (Amfibia)factory.GetVehicle(3);
                amfibia.new Engine(3);
                System.out.println(amfibia);
                System.out.println("Type of screws "+amfibia.getScrews());

                BatMobile batMobile = (BatMobile) factory.GetVehicle(4);
                System.out.println(batMobile);
                batMobile.new Engine(3);
                System.out.println(batMobile);
                batMobile.setCorpus(new BatMobile.Corpus(1));
                System.out.println("Type of corpus "+batMobile.getCorpus().getLevelOfUpgrade());
                batMobile.setCorpus(new BatMobile.Corpus(2));
                System.out.println("Type of corpus "+batMobile.getCorpus().getLevelOfUpgrade());
                System.out.println("BatMobiles changes: " + BatMobile.countOfCorpusChanges);
        }
	public static void main(String[] args) {
		testSortInterfaces();
		//testDetails();

	/*Plane pl1 = new Plane(0,0,1000000,300,2004,100,1000);

	Car c1 = new Car(2,5,3000,160,2013);
	Car c2 = new Car(10,8,2000,160,2003);
	Car c3 = new Car(3,9,5000,220,2015);

	Ship sh1 = new Ship(0,2,200000,200,2013,500,"Sevastopol");
	Ship sh2 = new Ship(5,2,300000,250,2014,600,"Nykolaev");
	Ship sh3 = new Ship(9,0,220000,200,2017,500,"Sevastopol");

	VehicleArray arr= new VehicleArray(new Vehicle[]{pl1,c1,c2,c3,sh1,sh2,sh3});*/
		/*System.out.println();
		System.out.println("Vehicle с наибольшей ценой");
		System.out.println(Controler.task1(arr));
		System.out.println();
		System.out.println("Mеханизм год выпуска 2000-2005 с  скоростью выше 150 км\\ч, и наименьшей ценой");
		System.out.println(Controler.task2(arr));
		System.out.println();
		System.out.println("Из Масива Vehicle получить масив Car не старше 5 лет");
		Controler.print(Controler.task3(arr));
		System.out.println();
		System.out.println("Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию");
		Controler.print(Controler.task4(arr));*/
    }
}
