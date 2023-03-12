package Supermarket.Main;
/**
 * Runs the program
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import General.EventQueue;
import General.Simulator;
import Supermarket.Events.CloseEvent;
import Supermarket.Events.EndEvent;
import Supermarket.Events.StartEvent;
import Supermarket.States.SupermarketState;
import Supermarket.View.SupermarketView;
import java.util.Observer;
import java.util.Observable;

public class RunSim {
    private EventQueue eventQueue;
    private SupermarketState state;
    private Simulator simulator;

    /**
     * Creates an instance of RunSim
     * @param openingTime the opening time
     * @param closingTime the closing time
     * @param maxCustomers the max amount of customers allowed
     * @param maxOpenRegisters the amount of registers in the store
     * @param lambda the rate of arrival
     * @param seed the seed
     * @param kMin minimum time to pay
     * @param kMax maximum time to pay
     * @param pMin minimum time to pick
     * @param pMax maximum time to pick
     */
    public RunSim(double openingTime, double closingTime, int maxCustomers, int maxOpenRegisters, double lambda,
                  long seed, double kMin, double kMax, double pMin, double pMax){
        // Creates an EventQueue
        eventQueue = new EventQueue();
        // Creates a state
        state = new SupermarketState(
                maxCustomers,
                maxOpenRegisters,
                lambda,
                seed,
                kMin,
                kMax,
                pMin,
                pMax);
        // Adds start, closing and end events
        eventQueue.addEvent(new StartEvent(eventQueue, openingTime, state));
        eventQueue.addEvent(new CloseEvent(eventQueue, closingTime, state));
        eventQueue.addEvent(new EndEvent(eventQueue, 999, state));
        // Creates a view
        SupermarketView view = new SupermarketView(state);
        state.addObserver(view);
        // Creates a simulator
        simulator = new Simulator(eventQueue, state);
        simulator.run();
    }

    /**
     * Runs the simulation by creating an instance of RunSim
     * @param args
     */
    public static void main(String[] args){
        RunSim runSim = new RunSim(0, 10.00, 5, 2, 1.0,
                1234, 2.0, 3.0, 0.5, 1.0);
        RunSim runSim2 = new RunSim(0, 8.00, 7, 2, 3.0,
                13, 0.35, 0.6, 0.6, 0.9);
    }
}
