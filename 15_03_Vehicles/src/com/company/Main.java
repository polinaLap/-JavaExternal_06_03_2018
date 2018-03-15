package com.company;

public class Main {

    public static void main(String[] args) {
	Plane pl1 = new Plane(0,0,1000000,300,2004,100,1000);

	Car c1 = new Car(2,5,3000,160,2013);
	Car c2 = new Car(10,8,2000,160,2003);
	Car c3 = new Car(3,9,5000,220,2015);

	Ship sh1 = new Ship(0,2,200000,200,2013,500,"Sevastopol");
	Ship sh2 = new Ship(5,2,300000,250,2014,600,"Nykolaev");
	Ship sh3 = new Ship(9,0,220000,200,2017,500,"Sevastopol");

	VehicleArray arr= new VehicleArray(new Vehicle[]{pl1,c1,c2,c3,sh1,sh2,sh3});
		System.out.println();
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
		Controler.print(Controler.task4(arr));
    }
}
