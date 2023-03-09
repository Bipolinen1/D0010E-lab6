package Supermarket.Main;
import General.EventQueue;
import Supermarket.Events.CloseEvent;
import Supermarket.States.Customer
import Supermarket.Events.StartEvent;
import Supermarket.States.SupermarketState;

public class RunSim {
    private EventQueue eventQueue;
    private SupermarketState state;

    public RunSim(double openingTime, double closingTime, int maxCustomers, int maxOpenRegisters, double lambda,
                  long seed, double kMin, double kMax, double pMin, double pMax){
        eventQueue = new EventQueue();
        eventQueue.add(new StartEvent(eventQueue, openingTime));
        eventQueue.add(new CloseEvent(eventQueue, closingTime));

        state = new SupermarketState(
                maxCustomers,
                maxOpenRegisters,
                openingTime,
                closingTime,
                lambda,
                seed,
                kMin,
                kMax,
                pMin,
                pMax);
    }
    public static void main(String[] args){

    }
}
