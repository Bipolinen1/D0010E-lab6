package Supermarket.Events;

import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.SupermarketState;

public class CloseEvent extends Event{
    public CloseEvent(EventQueue eventQueue, double eventTime, SupermarketState state) {
        super(eventQueue, eventTime, state);
    }


    public void execute(State state) {
        super.execute(state);
        ((SupermarketState)state).close();
        state.update("Close");
    }
}
