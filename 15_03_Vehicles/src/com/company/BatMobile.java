package com.company;

public class BatMobile extends Car implements IFly {
    public BatMobile(double x, double y, double price, double speed, int year) {
        super(x, y, price, speed, year);
        corpus = new Corpus(0);
        countOfCorpusChanges--;
    }

    @Override
    public void fly() {
        System.out.println("BatMobile fly");
    }

    @Override
    public void move() {
        System.out.println("BatMobile move");
    }

    @Override
    public String toString() {
        return "BatMobile{{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", price=" + getPrice() +
                ", speed=" + getSpeed() +
                ", year=" + getYear() +
                '}';
    }

    public class Engine  extends Vehicle.Engine{
        public Engine(int type){
            this.type=type;
            BatMobile.this.setSpeed(BatMobile.this.getSpeed()+30*type);
            BatMobile.this.setPrice(BatMobile.this.getPrice()+200*type);
        }
    }

    public static int countOfCorpusChanges=0;
    private Corpus corpus;

    public Corpus getCorpus() {
        return corpus;
    }
    public void setCorpus(Corpus corpus){
        this.corpus=corpus;
    }
    public static class Corpus{
        private static int levelOfUpgrade=0;
        public Corpus(int level) {
            levelOfUpgrade=level;
            countOfCorpusChanges++;
        }

        public int getLevelOfUpgrade() {
            return levelOfUpgrade;
        }
    }
}
