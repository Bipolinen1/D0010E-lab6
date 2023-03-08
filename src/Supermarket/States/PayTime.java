package Supermarket.States;
import Supermarket.Random.UniformRandomStream;

    public class PayTime {
    private double kMin;
    private double kMax;
    private long seed;
    private UniformRandomStream rand;
    public PayTime(double pMax, double pMin, long seed) {
        this.kMax = kMax;
        this.kMin = kMin;
        this.seed = seed;
        rand = new UniformRandomStream(kMax, kMin, seed);

    }
    public double calculatePickTime(double currentTime) {
        return currentTime + rand.next();
    }
}


