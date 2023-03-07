package Supermarket.Events;

import General.State;
import General.Event;
import General.EventQueue;

public class CloseEvent extends SupermarketEvent{
    public CloseEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }

    @Override
    public void execute() {

    }
}
