package Supermarket.States;
/**
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
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
        rand = new UniformRandomStream(pMin, pMax, seed);
    }
    public double calculatePickTime(double currentTime){
        return currentTime + rand.next(); //currentTime + rand.next() adds pMax, pMin and seed together
                                        //and puts it in the variable current time
    }
}
