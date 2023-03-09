package Supermarket.Events;

import General.Event;
import General.EventQueue;
import Supermarket.States.SupermarketState;

public class EndEvent extends Event {
    public EndEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }
    public void execute(SupermarketState state){
        state.stop();
    }
}
