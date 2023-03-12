package Supermarket.States;
/**
 * Calculates time for payment
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import Supermarket.Random.UniformRandomStream;

    public class PayTime {
        private double kMin;
        private double kMax;
        private long seed;
        private UniformRandomStream rand;

        /**
         * Creates an instance of PayTime
         * @param kMax max time to pay
         * @param kMin min time to pay
         * @param seed the seed
         */
        public PayTime(double kMax, double kMin, long seed) {
            this.kMax = kMax;
            this.kMin = kMin;
            this.seed = seed;
            rand = new UniformRandomStream(kMin, kMax, seed);

        }

        /**
         * Calculates the paytime
         * @param currentTime the current time
         * @return the calculated pay time as currentTime + a random value between kMin and kMax
         */
        public double calculatePayTime(double currentTime) {
            return currentTime + rand.next();
        }
    }


