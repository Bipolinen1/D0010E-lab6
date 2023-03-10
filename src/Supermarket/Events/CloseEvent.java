package Supermarket.Events;

import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.SupermarketState;

public class CloseEvent extends Event{
    public CloseEvent(EventQueue eventQueue, double eventTime, SupermarketState state) {
        super(eventQueue, eventTime, state);
    }

    @Override
    public void execute() {
        super.execute();
        state.update(this);
        ((SupermarketState)state).close();

    }


    public String getName(){
        return "Close";
    }
}
