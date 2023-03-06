package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;

public class PickEvent extends CustomerEvent {
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    @Override
    public void execute() {

    }
}
