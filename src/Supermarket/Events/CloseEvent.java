package Supermarket.Events;

import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.SupermarketState;

public class CloseEvent extends Event{
    public CloseEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }


    public void execute(SupermarketState state) {
        super.execute(state);
        state.close();
        state.update("Close");
    }
}
