package javaclasses;

public class TarifGanerator {
    private final int TYPE_TARIFS = 8;
    private final int RANGE_MBS = 3000;
    private final int RANGE_SMS = 200;
    private final int RANGE_MINS_PER_DAY = 180;
    private final int RANGE_MINS_PER_DAY_INTERCALLS = 180;

    Tarif generateTarif(int i){
        switch (i){
            case 0: return new PatriotTarif((int)(Math.random()*RANGE_MBS),(int)(Math.random()*RANGE_SMS),(int)(Math.random()*RANGE_MINS_PER_DAY));
            case 1: return new InternationalTarif((int)(Math.random()*RANGE_MBS),(int)(Math.random()*RANGE_SMS),
                    (int)(Math.random()*RANGE_MINS_PER_DAY),(int)(Math.random()*RANGE_MINS_PER_DAY_INTERCALLS),
                    new InternationalTarif.Countries[] {InternationalTarif.Countries.GERMANY,
                            InternationalTarif.Countries.ENGLAND,InternationalTarif.Countries.FRANCE});
            case 2: return new PlusSMS(generateTarif(0),20);
            case 3: return new PlusSMS(generateTarif(1),20);
            case 4: return new PlusInternet(generateTarif(0),500);
            case 5: return new PlusInternet(generateTarif(1),500);
            case 6: return new PlusInternet(generateTarif(2),500);
            case 7: return new PlusInternet(generateTarif(3),500);
            default:{
                System.out.println("Wrong number of Tarif");
                return null;
            }
        }
    }
    Tarif generateTarif(){
        return generateTarif((int)(Math.random()*TYPE_TARIFS));

    }
}
