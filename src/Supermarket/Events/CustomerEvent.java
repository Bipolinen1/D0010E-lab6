package Supermarket.Events;
import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public abstract class CustomerEvent extends Event {
    protected Customer customer;
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
