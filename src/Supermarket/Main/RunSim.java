package Supermarket.Main;
import General.EventQueue;
import General.Simulator;
import Supermarket.Events.CloseEvent;
import Supermarket.Events.StartEvent;
import Supermarket.States.SupermarketState;
import Supermarket.View.SupermarketView;

public class RunSim {
    private EventQueue eventQueue;
    private SupermarketState state;
    private Simulator simulator;

    public RunSim(double openingTime, double closingTime, int maxCustomers, int maxOpenRegisters, double lambda,
                  long seed, double kMin, double kMax, double pMin, double pMax){
        eventQueue = new EventQueue();
        eventQueue.add(new StartEvent(eventQueue, openingTime));
        eventQueue.add(new CloseEvent(eventQueue, closingTime));

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


        simulator.run();
    }
    public static void main(String[] args){
    }
}
