package Supermarket.Events;

import General.Event;
import General.EventQueue;
import Supermarket.States.*;


public class StartEvent extends SupermarketEvent{

    public StartEvent(EventQueue eventQueue, double eventTime){
        super(eventQueue, eventTime);
    }

    @Override
    public void execute() {
        eventQueue.add(new ArrivalEvent(eventQueue, 0, state.createCustomer()));
    }
}
