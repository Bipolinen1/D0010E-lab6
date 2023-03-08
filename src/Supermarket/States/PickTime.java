package Supermarket.States;
import Supermarket.Random.UniformRandomStream;
public class PickTime {
    private double pMin;
    private double pMax;
    private long seed;
    private UniformRandomStream rand;

    public PickTime(double pMax, double pMin, long seed){
        this.pMax = pMax;
        this.pMin = pMin;
        this.seed = seed;
        rand = new UniformRandomStream(pMax, pMin, seed);
    }
    public double calculatePickTime(double currentTime){
        return currentTime + rand.next();
    }
}
