package javaclasses;

import java.io.InvalidObjectException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void countOfAbonents(TarifsArray arr){
        System.out.println("Sum of abonents must be 4");
        System.out.println("Real sum = "+arr.sumOfAbonents()+"\n");
    }
    public static void sortArrayByAbonPlata(TarifsArray arr){
        arr.sortAbonPlatu();
        for (int i = 0; i < arr.length(); i++) {
            System.out.print((i+1)+". ");
            arr.getTarif(i).printInfo();
            System.out.println("AbonPlata = "+arr.getTarif(i).cost());
        }
    }
    public static void selectByParametres(){
        Tarif t1 = new PatriotTarif(50,100,100);
        Tarif t2 = new PatriotTarif(200,100,200);
        Tarif t3 = new PatriotTarif(50,300,400);
        Tarif t4 = new PatriotTarif(50,100,600);
        Tarif t5 = new InternationalTarif(50,100,400,200,new InternationalTarif.Countries[]{InternationalTarif.Countries.ENGLAND});
        TarifsArray arr = new TarifsArray(5);
        arr.setTarif(0,t1); arr.setTarif(1,t2);arr.setTarif(2,t3);arr.setTarif(3,t4);arr.setTarif(4,t5);
        TarifsArray res = arr.select(0,100,10,200,0,500,0,100);

        res.printInfo();
    }
    public static void serializeTestArray(int n){
        TarifGanerator g = new TarifGanerator();
        for (int i = 0; i < n; i++) {
            Tarif cur = g.generateTarif();
            if(i<4) cur.registerObserver(new Abonent());
            String file = "src\\test\\java\\javaclasses\\tarif"+i+".data";
            Serializator sz = new Serializator();
            sz.serialization(cur,file);
        }
    }
    public static TarifsArray deserializeTestArray(int n){
        TarifsArray arr = new TarifsArray(6);
        for (int i = 0; i <arr.length() ; i++) {
            String file = "src\\test\\java\\javaclasses\\tarif"+i+".data";
            Serializator sz = new Serializator();
            try{
                arr.setTarif(i,sz.deserialization(file));

            }catch (InvalidObjectException e){
                e.printStackTrace();
            }
        }
        return arr;
    }
    public static void main( String[] args )
    {

        serializeTestArray(6);
        TarifsArray arr =  deserializeTestArray(6);
        countOfAbonents(arr);
        sortArrayByAbonPlata(arr);
        selectByParametres();

    }
}
