package Supermarket.Events;

import General.Event;
import General.EventQueue;
import Supermarket.States.SupermarketState;

public abstract class SupermarketEvent extends Event {
    protected SupermarketState state;
    public SupermarketEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }
}
