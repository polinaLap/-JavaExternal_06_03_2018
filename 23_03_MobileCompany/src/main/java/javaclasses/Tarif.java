package javaclasses;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Tarif implements Subject, Comparable<Tarif>,Serializable{
    private int countMb;
    private int countSMS;
    private int minsPerDay;
    private int minsPerDayInternCalls;

    private ArrayList <Observer> abonents;

    public abstract void printInfo();
    public abstract double cost();
    public int abonentsCount(){
        if(abonents==null) return 0;
        return abonents.size();
    }
    public Tarif(int countMb,int countSMS, int minsPerDay, int minsPerDayInternCalls) {
        this.countMb = countMb;
        this.countSMS=countSMS;
        this.minsPerDay = minsPerDay;
        this.minsPerDayInternCalls = minsPerDayInternCalls;
        abonents= new ArrayList<Observer>();
    }
    public Tarif(){
        abonents=new ArrayList<Observer>();
    }
    public void changeTarif(int countMb,int countSMS, int minsPerDay, int minsPerDayInternCalls) {
        this.countMb = countMb;
        this.countSMS=countSMS;
        this.minsPerDay = minsPerDay;
        this.minsPerDayInternCalls = minsPerDayInternCalls;
        notifyObeservers();
    }
    public int getCountSMS() {
        return countSMS;
    }

    public int getCountMb() {
        return countMb;
    }

    public int getMinsPerDay() {
        return minsPerDay;
    }

    public int getMinsPerDayInternCalls() {
        return minsPerDayInternCalls;
    }

    public void registerObserver(Observer o) {
        if(abonents!=null)
            abonents.add((o));
    }

    public void removeObserver(Observer o) {
        if(abonents!=null){
            int i = abonents.indexOf(o);
            if(i>=0) abonents.remove(i);
        }    }

    public void notifyObeservers() {
        if(abonents==null) return;
        for (int i = 0; i < abonents.size();i++) {
            Observer observer =  (Observer) abonents.get(i);
            observer.update(cost(),countMb,countSMS,minsPerDay,minsPerDayInternCalls);
        }
    }


    @Override
    public String toString() {
        return "Tarif has: " +
                "countMb=" + getCountMb() +
                ", countSMS=" +getCountSMS() +
                ", minsPerDay=" +getMinsPerDay() +
                ", minsPerDayInternCalls=" + getMinsPerDayInternCalls();
    }

    public int compareTo(Tarif tarif) {
        return ((Double)cost()).compareTo(tarif.cost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarif tarif = (Tarif) o;
        return getCountMb() == tarif.getCountMb() &&
                getCountSMS() == tarif.getCountSMS() &&
                getMinsPerDay() == tarif.getMinsPerDay() &&
                getMinsPerDayInternCalls() == tarif.getMinsPerDayInternCalls() &&
                Math.abs(cost()-((Tarif) o).cost())<0.000001&&
                abonents.equals(((Tarif) o).abonents);
    }

    public ArrayList<Observer> getAbonents() {
        return abonents;
    }
}
