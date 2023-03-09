package Supermarket.Main;
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

    public RunSim(double openingTime, double closingTime, int maxCustomers, int maxOpenRegisters, double lambda,
                  long seed, double kMin, double kMax, double pMin, double pMax){
        eventQueue = new EventQueue();
        eventQueue.add(new StartEvent(eventQueue, openingTime));
        eventQueue.add(new CloseEvent(eventQueue, closingTime));
        eventQueue.add(new EndEvent(eventQueue, 999));

        state = new SupermarketState(
                maxCustomers,
                maxOpenRegisters,
                lambda,
                seed,
                kMin,
                kMax,
                pMin,
                pMax);

        SupermarketView view = new SupermarketView();
        state.addObserver(view);
        simulator = new Simulator(eventQueue, state);
        simulator.run();
    }
    public static void main(String[] args){
        RunSim runSim = new RunSim(0, 10.00, 5, 2, 1.0,
                1234, 2.0, 3.0, 0.5, 1.0);
    }
}
