package Supermarket.States;
/**
 * Calculates the arrival time
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import Supermarket.Random.ExponentialRandomStream;

public class ArrivalTime {
    private double lambda;
    private ExponentialRandomStream rand;
    private long seed;

    /**
     * Creates an instance of ArrivalTime
     * @param lambda rate of customers arriving
     * @param seed the seed
     */
    public ArrivalTime(double lambda, long seed){
        this.lambda = lambda;
        this.seed = seed;
        rand = new ExponentialRandomStream(lambda, seed);
    }

    /**
     * Räknar ut arrival tid som nuvarande tid + ett slumptal
     * @param currentTime the current time
     * @return the calculated time
     */
    public double calculateArrivalTime(double currentTime){
        return currentTime + rand.next();
    }

}
