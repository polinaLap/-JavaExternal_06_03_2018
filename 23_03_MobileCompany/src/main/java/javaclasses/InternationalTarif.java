package javaclasses;

public class InternationalTarif extends Tarif  {
    private Countries[] countries;

    public Countries[] getCountries() {
        return countries;
    }

    public InternationalTarif(int countMb, int countSMS, int minsPerDay, int minsPerDayInternCalls, Countries[] countries) {
        super(countMb,countSMS, minsPerDay, minsPerDayInternCalls);
        this.countries=countries;
    }
    public void printInfo() {
        System.out.println("This is tarif for international calls.\nYou can call to abonents in\n"+toString()
                + " and also in Ukraine.\n"+ super.toString());
    }

    public double cost() {
        return 50.0+countries.length*20.0;
    }

    public String toString() {
        String res="";
        for (int i = 0; i < countries.length; i++) {
            res+=countries[i]+", ";
        }
        return res;
    }
    public static enum Countries{RUSSIA, ENGLAND, USA, FRANCE, GERMANY, POLAND, ITALY}

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
                getAbonents().equals(((Tarif) o).getAbonents())&&
                countries.length==((InternationalTarif)o).getCountries().length;
    }
}
