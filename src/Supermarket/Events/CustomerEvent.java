package Supermarket.Events;

import General.Event;
import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public abstract class CustomerEvent extends SupermarketEvent {
    protected Customer customer;
    public CustomerEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime);
    }

    @Override
    public abstract void execute();


}
