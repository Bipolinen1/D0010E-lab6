package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;

public class PayEvent extends CustomerEvent {
    public PayEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    @Override
    public void execute() {

    }
}
