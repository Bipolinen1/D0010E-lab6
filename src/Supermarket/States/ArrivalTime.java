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

    // Räknar ut arrival tid som nuvarande tid + ett slumptal
    public double calculateArrivalTime(double currentTime){
        return currentTime + rand.next();
    }

}
