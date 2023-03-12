package Supermarket.Events;
/**
 * Inherits the general Event class and starts the simulation
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.Event;
import General.EventQueue;
import General.State;
import Supermarket.States.*;


public class StartEvent extends Event{
    /**
     * Creates an instance of StartEvent
     * @param eventQueue reference to the eventQueue
     * @param eventTime the time the event occurs
     * @param state the state
     */
    public StartEvent(EventQueue eventQueue, double eventTime, SupermarketState state){
        super(eventQueue, eventTime, state);
    }

    /**
     * The effect of the event. Adds the first ArrivalEvent to eventQueue
     */
    @Override
    public void execute() {
        super.execute();
        state.update(this);
        // Adds the first arrivalEvent and creates the first customer
        eventQueue.addEvent(new ArrivalEvent(eventQueue, ((SupermarketState)state).getArrivalTime(),
                ((SupermarketState)state).createCustomer(), ((SupermarketState)state)));

    }

    /**
     * Returns what type of event it is
     * @return the name of the event
     */
    public String getName(){
        return "Start";
    }
}
