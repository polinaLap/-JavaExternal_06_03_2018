package javaclasses;

import java.util.Arrays;

public class TarifsArray {
    private Tarif[] tarifs;

    public int length() {
        return n;
    }

    private int n;

    public TarifsArray(int n) {
        this.tarifs = new Tarif[n];
        this.n=n;
    }
    public TarifsArray() {
        this(0);
    }
    public void add(Tarif tarif){
        Tarif[] newTarifs= new Tarif[++n];
        for (int i = 0; i < tarifs.length; i++) {
            newTarifs[i]=tarifs[i];
        }
        newTarifs[n-1]=tarif;
        tarifs=newTarifs;
    }
    public void setTarif(int i, Tarif tarif){
        if(i>=n) return;
        tarifs[i]= tarif;
    }
    public Tarif getTarif(int i) throws ArrayIndexOutOfBoundsException{
        if(i>=n) throw new ArrayIndexOutOfBoundsException("There is not tarif with this index!");
        return tarifs[i];
    }
    public int sumOfAbonents(){
        int sum=0;
        for (int i = 0; i < tarifs.length; i++) {
            sum+=tarifs[i].abonentsCount();
        }
        return sum;
    }
    public void sortAbonPlatu(){
        Arrays.sort(tarifs);
    }
    public TarifsArray select(int minCountMb, int maxCountMb,int minCountSMS,int maxCountSMS,
                              int minMinsPerDay,int maxMinsPerDay,int minMinsPerDayInternCalls,int maxMinsPerDayInternCalls){
        TarifsArray res = new TarifsArray();
        for (int i = 0; i < tarifs.length; i++) {
            if(tarifs[i].getCountMb()>=minCountMb&&tarifs[i].getCountMb()<=maxCountMb)
                if(tarifs[i].getCountSMS()>=minCountSMS&&tarifs[i].getCountSMS()<=maxCountSMS)
                    if(tarifs[i].getMinsPerDay()>=minMinsPerDay&&tarifs[i].getMinsPerDay()<=maxMinsPerDay)
                        if(tarifs[i].getMinsPerDayInternCalls()>=minMinsPerDayInternCalls&&tarifs[i].getMinsPerDayInternCalls()<=maxMinsPerDayInternCalls)
                            res.add(tarifs[i]);
        }
        return res;
    }
    public TarifsArray selectByMbs(int minCountMb, int maxCountMb){
        return select(minCountMb,maxCountMb,0,Integer.MAX_VALUE,0,Integer.MAX_VALUE,0,Integer.MAX_VALUE);
    }
    public TarifsArray selectBySMS(int minCountSMS, int maxCountSMS){
        return select(0,Integer.MAX_VALUE,minCountSMS, maxCountSMS,0,Integer.MAX_VALUE,0,Integer.MAX_VALUE);
    }
    public TarifsArray selectByMinsPerDay(int minMinsPerDay,int maxMinsPerDay){
        return select(0,Integer.MAX_VALUE,0,Integer.MAX_VALUE,minMinsPerDay,maxMinsPerDay,0,Integer.MAX_VALUE);
    }
    public TarifsArray selectByMinsPerDayInternCalls(int minMinsPerDayInternCalls,int maxMinsPerDayInternCalls){
        return select(0,Integer.MAX_VALUE,0,Integer.MAX_VALUE,0,Integer.MAX_VALUE, minMinsPerDayInternCalls, maxMinsPerDayInternCalls);
    }


    public void printInfo() {
        System.out.println("\nTarifs array has:");
        for (int i = 0; i < tarifs.length; i++) {
            System.out.print((i+1)+". ");
            tarifs[i].printInfo();
        }
    }
}
