package Supermarket.Events;

import General.Event;
import General.EventQueue;
import General.State;
import Supermarket.States.*;


public class StartEvent extends Event{

    public StartEvent(EventQueue eventQueue, double eventTime){
        super(eventQueue, eventTime);
    }

    public void execute(SupermarketState state) {
        super.execute(state);

        eventQueue.add(new ArrivalEvent(eventQueue, state.getArrivalTime(), state.createCustomer()));
    }
}
