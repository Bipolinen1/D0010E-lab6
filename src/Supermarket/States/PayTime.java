package Supermarket.States;
/**
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import Supermarket.Random.UniformRandomStream;

    public class PayTime {
        private double kMin;
        private double kMax;
        private long seed;
        private UniformRandomStream rand;

        public PayTime(double kMax, double kMin, long seed) {
            this.kMax = kMax;
            this.kMin = kMin;
            this.seed = seed;
            rand = new UniformRandomStream(kMin, kMax, seed);

        }

        public double calculatePayTime(double currentTime) {
            return currentTime + rand.next();
        }
    }


