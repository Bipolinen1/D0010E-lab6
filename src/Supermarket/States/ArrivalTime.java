package Supermarket.States;

import Supermarket.Random.ExponentialRandomStream;

public class ArrivalTime {
    private double lambda;
    private ExponentialRandomStream rand;
    private long seed;

    public ArrivalTime(double lambda, long seed){
        this.lambda = lambda;
        this.seed = seed;
        rand = new ExponentialRandomStream(lambda, seed);
    }

    //TODO ska ge tid + rand tror jag, men vet inte var jag ska skapa currentTime
    public double calculateArrivalTime(){
        return 0;
    }
}
