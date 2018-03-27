package javaclasses;

public class PlusInternet extends Additionals {

    private Tarif baseTarif;
    private int countMbs;
    public PlusInternet(Tarif baseTarif, int countMbs) {
        this.baseTarif = baseTarif;
        this.countMbs=countMbs;
    }

    @Override
    public void printInfo() {
        baseTarif.printInfo();
        System.out.println("Additional Mbs: "+countMbs+ " Mbs.");
    }

    @Override
    public double cost() {
        return baseTarif.cost()+countMbs*0.1;
    }

    @Override
    public int getCountMb() {
        return baseTarif.getCountMb()+countMbs;
    }
}
