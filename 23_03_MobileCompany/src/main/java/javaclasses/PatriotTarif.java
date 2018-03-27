package javaclasses;

public class PatriotTarif extends Tarif {
    public PatriotTarif(int countMb,int countSMS, int minsPerDay) {
        super(countMb,countSMS, minsPerDay, 0);
    }

    public void printInfo() {
        System.out.println("This is tarif for patriots.\nYou can call only to abonents in Ukraine\n"+toString());
    }

    public double cost() {
        return 60.0 ;
    }

    @Override
    public String toString() {
        return "Tarif has: " +
                "countMb=" + getCountMb() +
                ", countSMS=" + getCountSMS() +
                ", minsPerDay=" + getMinsPerDay() +
                '}';
    }
}
