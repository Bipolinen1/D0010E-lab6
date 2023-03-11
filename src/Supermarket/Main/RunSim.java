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
        System.out.println(eventQueue);
        state = new SupermarketState(
                maxCustomers,
                maxOpenRegisters,
                lambda,
                seed,
                kMin,
                kMax,
                pMin,
                pMax);

        eventQueue.addEvent(new StartEvent(eventQueue, openingTime, state));
        eventQueue.addEvent(new CloseEvent(eventQueue, closingTime, state));
        eventQueue.addEvent(new EndEvent(eventQueue, 999, state));

        SupermarketView view = new SupermarketView(state);
        state.addObserver(view);
        simulator = new Simulator(eventQueue, state);
        simulator.run();
    }
    public static void main(String[] args){
        RunSim runSim = new RunSim(0, 10.00, 5, 2, 1.0,
                1234, 2.0, 3.0, 0.5, 1.0);
    }
}
