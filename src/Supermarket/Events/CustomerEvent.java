package Supermarket.Events;
/**
 * This class is a specific general class that seperates customer events from supermarket events
 * Inherits the general Event class
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public abstract class CustomerEvent extends Event {
    protected Customer customer;

    /**
     * Creates an instance of CustomerEvent
     * @param eventQueue reference to the eventQueue
     * @param eventTime the time the event should execute
     * @param customer the customer connected to the event
     * @param state the state
     */
    public CustomerEvent(EventQueue eventQueue, double eventTime, Customer customer, State state) {
        super(eventQueue, eventTime, state);
        this.customer = customer;
    }

    @Override
    public void execute(){
        super.execute();
    }

    public Customer getCustomer(){
        return this.customer;
    }
}
