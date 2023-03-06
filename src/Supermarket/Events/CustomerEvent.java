package Supermarket.Events;

import General.Event;
import General.EventQueue;
import Supermarket.States.Customer;

public abstract class CustomerEvent extends Event {
    protected Customer customer;
    public CustomerEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime);
    }

    @Override
    public abstract void execute();


}
