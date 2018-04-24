package javaclasses;

import org.junit.Test;
import junit.framework.Assert;
import java.io.InvalidObjectException;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends Assert
{
    @Test
    public void testRegisterObserver(){
        Abonent a = new Abonent();
        Tarif t = new PatriotTarif(0,0,0);
        t.registerObserver(a);
        int expCount=1; int count= t.abonentsCount();
        assertEquals(expCount,count);

    }
    @Test
    public void testNotifyObservers(){
        Abonent a = new Abonent();
        Tarif t = new PatriotTarif(0,0,0);
        t.registerObserver(a);
        t.changeTarif(100,0,0,0);
        int expCount =100; int count = a.countOfMb;
        assertEquals(expCount,count);
    }
    @Test
    public void testRemoveObservers(){
        Abonent a = new Abonent();
        Tarif t = new PatriotTarif(0,0,0);
        t.registerObserver(a);
        t.removeObserver(a);
        int expCount =0; int count = t.abonentsCount();
        assertEquals(expCount,count);
    }
    @Test
    public void testCountSMSInPlusSMS(){
        Tarif t1 = new PatriotTarif(0,100,0);
        Tarif t2=new PlusSMS(t1,100);
        int expCount =200; int count = t2.getCountSMS();
        assertEquals(expCount,count);
    }
    @Test
    public void testCostInPlusSMS(){
        Tarif t1 = new PatriotTarif(0,100,0);
        Tarif t2=new PlusSMS(t1,100);
        double expCost =160; double cost = t2.cost();
        assertEquals(expCost,cost,0.000001);
    }
    @Test
    public void testCountMbsInPlusMbs(){
        Tarif t1 = new PatriotTarif(100,0,0);
        Tarif t2=new PlusInternet(t1,100);
        int expCount =200; int count = t2.getCountMb();
        assertEquals(expCount,count);
    }
    @Test
    public void testCostInPlusMbs(){
        Tarif t1 = new PatriotTarif(100,0,0);
        Tarif t2=new PlusInternet(t1,1000);
        double expCost =160; double cost = t2.cost();
        assertEquals(expCost,cost,0.000001);
    }
    @Test
    public void testCostInInternationalTarif(){
        Tarif t = new InternationalTarif(0,0, 0,0,
                new InternationalTarif.Countries[] {InternationalTarif.Countries.GERMANY,
                        InternationalTarif.Countries.ENGLAND,InternationalTarif.Countries.FRANCE});
        double expCost =110; double cost = t.cost();
        assertEquals(expCost,cost,0.000001);
    }
    @Test
    public void testTarifGeneratorIfIOutOfRange(){
        TarifGanerator g = new TarifGanerator();
        Tarif t = g.generateTarif(8);
        Tarif expTarif =null;
        assertEquals(expTarif,t);
    }
    @Test
    public void testTarifsArrayAddMethod(){
        TarifsArray arr = new TarifsArray();
        Tarif t1 = new  PatriotTarif(0,0,0);
        Tarif t2 = new  PatriotTarif(0,0,0);
        arr.add(t1);
        arr.add(t2);
        assertSame(t2,arr.getTarif(1));
    }
    @Test
    public void testTarifsArraySetTarifMethod(){
        TarifsArray arr = new TarifsArray();
        Tarif t1 = new  PatriotTarif(0,0,0);
        Tarif t2 = new  PatriotTarif(1,0,0);
        Tarif t3 = new  PatriotTarif(2,0,0);
        arr.add(t1);
        arr.add(t2);
        arr.setTarif(1,t3);
        assertSame(t3,arr.getTarif(1));
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testTarifsArrayGetTarifMethod(){
        TarifsArray arr = new TarifsArray();
        Tarif t1 = new  PatriotTarif(0,0,0);
        arr.add(t1);
        arr.getTarif(1);
    }
    @Test
    public void testTarifsArraySumOfAbonentsMethod(){
        TarifsArray arr = new TarifsArray();
        Tarif t1 = new  PatriotTarif(0,0,0);
        Tarif t2 = new  PatriotTarif(0,0,0);
        Abonent a1 = new Abonent();
        Abonent a2 = new Abonent();
        Abonent a3 = new Abonent();
        t1.registerObserver(a1);t2.registerObserver(a1);
        t1.registerObserver(a2);t2.registerObserver(a2);
        t1.registerObserver(a3);t2.registerObserver(a3);
        arr.add(t1);
        arr.add(t2);
        int expCount =6; int count = arr.sumOfAbonents();
        assertEquals(expCount,count);
    }
    @Test
    public void testTarifsArraySortAbonPlatu(){
        TarifGanerator gen = new TarifGanerator();
        TarifsArray arr = new TarifsArray(10);
        for (int i = 0; i < 10; i++) {
            arr.setTarif(i,gen.generateTarif());
        }
        arr.sortAbonPlatu();
        boolean isOk =true;
        for (int i = 0; i < 9; i++) {
            if(arr.getTarif(i).cost()>arr.getTarif(i+1).cost()){isOk=false;break;}
        }
        assertEquals(true,isOk);
    }
    @Test
    public void testTarifsArraySelectMethod(){
        Tarif t1 = new PatriotTarif(50,100,100);
        Tarif t2 = new PatriotTarif(200,100,200);
        Tarif t3 = new PatriotTarif(50,300,400);
        Tarif t4 = new PatriotTarif(50,100,600);
        Tarif t5 = new InternationalTarif(50,100,400,200,new InternationalTarif.Countries[]{InternationalTarif.Countries.ENGLAND});
        TarifsArray arr = new TarifsArray(5);
        arr.setTarif(0,t1); arr.setTarif(1,t2);arr.setTarif(2,t3);arr.setTarif(3,t4);arr.setTarif(4,t5);
        TarifsArray res = arr.select(0,100,10,200,0,500,0,100);
        assertEquals(1,res.length());
    }
    @Test
    public void testTarifsArraySelectByMbsMethod(){
        Tarif t1 = new PatriotTarif(50,100,100);
        Tarif t2 = new PatriotTarif(200,100,200);
        Tarif t3 = new PatriotTarif(50,300,400);
        Tarif t4 = new PatriotTarif(50,100,600);
        TarifsArray arr = new TarifsArray(4);
        arr.setTarif(0,t1); arr.setTarif(1,t2);arr.setTarif(2,t3);arr.setTarif(3,t4);
        TarifsArray res = arr.selectByMbs(0,150);
        assertEquals(3,res.length());
    }
    @Test
    public void testSerializatorSimpleTarif(){
        Tarif t = new PatriotTarif(50,100,100);
        Serializator s = new Serializator();
        String file = "src\\test\\java\\javaclasses\\testSerializatorSimpleTarif.data";
        s.serialization(t,file);
        Tarif res = null;
        try{
             res = s.deserialization(file);

        }catch (InvalidObjectException e){
            e.printStackTrace();
        }
        assertEquals(t,res);

    }
    @Test
    public void testSerializatorTarifWithAbonents(){
        Tarif t = new PatriotTarif(50,100,100);
        t.registerObserver(new Abonent());
        Serializator s = new Serializator();
        String file = "src\\test\\java\\javaclasses\\testSerializatorTarifWithAbonents.data";
        s.serialization(t,file);
        Tarif res = null;
        try{
            res = s.deserialization(file);

        }catch (InvalidObjectException e){
            e.printStackTrace();
        }
        assertEquals(t,res);
    }
    @Test
    public void testSerializatorTarifInternational(){
        Tarif t = new TarifGanerator().generateTarif(1);
        Serializator s = new Serializator();
        String file = "src\\test\\java\\javaclasses\\testSerializatorTarifInternational.data";
        s.serialization(t,file);
        Tarif res = null;
        try{
            res = s.deserialization(file);

        }catch (InvalidObjectException e){
            e.printStackTrace();
        }
        assertEquals(t,res);
    }
    @Test
    public void testSerializatorFileNotFoundExceptionInSerialzation(){
        String file = "\\notExistedFolder\\ji.data";
        Tarif t = new TarifGanerator().generateTarif(1);
        Serializator s = new Serializator();
        boolean isOk = s.serialization(t,file);
        assertEquals(false,isOk);
    }
    @Test(expected = InvalidObjectException.class)
    public void testSerializatorInvalidObjectException() throws InvalidObjectException {
        String file = "src\\test\\java\\javaclasses\\testSerializatorInvalidObjectException.data";
        Serializator s = new Serializator();
        s.deserialization(file);
    }
}
