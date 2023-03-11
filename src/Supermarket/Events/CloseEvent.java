package Supermarket.Events;
/**
 * This class closes the supermarket. It inherits the general Event class
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.SupermarketState;

public class CloseEvent extends Event{
    /**
     * Instantiates a CloseEvent
     * @param eventQueue refernce to the eventQueue
     * @param eventTime the time the event should happen
     * @param state
     */
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
