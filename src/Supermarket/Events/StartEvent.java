package Supermarket.Events;

import General.Event;
import General.EventQueue;
import Supermarket.States.Customer;

public class StartEvent extends Event{
    public StartEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }

    @Override
    public void execute() {
        eventQueue.add(new ArrivalEvent(eventQueue, 0, new Customer(1)));
    }
}
