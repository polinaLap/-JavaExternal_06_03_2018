package javaclasses;

public class PlusSMS extends Additionals {
    private Tarif baseTarif;
    private int countSMS;
    public PlusSMS(Tarif baseTarif, int countSMS) {
        this.baseTarif = baseTarif;
        this.countSMS=countSMS;
    }

    @Override
    public int getCountSMS() {
        return baseTarif.getCountSMS()+countSMS;
    }

    @Override
    public void printInfo() {
        baseTarif.printInfo();
        System.out.println("Additional SMS: "+countSMS+ " SMS.");
    }

    @Override
    public double cost() {
        return baseTarif.cost()+countSMS*1;
    }
}
