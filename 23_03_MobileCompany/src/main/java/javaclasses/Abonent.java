package javaclasses;

import java.io.Serializable;


public class Abonent implements Observer,Serializable{
    double abonPlata;
    int countOfMb;
    int countOfSMS;
    int minutesPerDay;
    int minutesForInternCalls;

    public void update(double abonPlata, int countOfMb,int countOfSMS, int minutesPerDay, int minutesForInternCalls) {
        this.abonPlata=abonPlata;
        this.countOfMb=countOfMb;
        this.countOfSMS=countOfSMS;
        this.minutesForInternCalls=minutesForInternCalls;
        this.minutesPerDay=minutesPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abonent)) return false;
        Abonent abonent = (Abonent) o;
        return Double.compare(abonent.abonPlata, abonPlata) == 0 &&
                countOfMb == abonent.countOfMb &&
                countOfSMS == abonent.countOfSMS &&
                minutesPerDay == abonent.minutesPerDay &&
                minutesForInternCalls == abonent.minutesForInternCalls;
    }

}
