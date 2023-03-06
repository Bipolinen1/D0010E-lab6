package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;

public class ArrivalEvent extends CustomerEvent {
    public ArrivalEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    @Override
    public void execute() {

    }
}
