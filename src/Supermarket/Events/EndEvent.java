package Supermarket.Events;
/**
 * The class ends the simulation. It inherits the general Event class
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.Event;
import General.EventQueue;
import General.State;
import Supermarket.States.SupermarketState;

public class EndEvent extends Event {
    /**
     *
     * Instantiates a EndEvent
     * @param eventQueue reference to the eventQueue
     * @param eventTime the time the event happens
     * @param state the state
     */
    public EndEvent(EventQueue eventQueue, double eventTime, State state) {
        super(eventQueue, eventTime, state);
    }

    /**
     * The effect the event has. Stops the simulation
     */
    @Override
    public void execute(){
        super.execute();
        state.update(this);
        // Stops the simulation
        state.stop();
    }
    /**
     * Returns what type of event it is
     * @return the name of the event
     */
    public String getName(){
        return "End";
    }
}
