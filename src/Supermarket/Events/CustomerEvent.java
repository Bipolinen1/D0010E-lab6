package Supermarket.Events;
import General.State;
import General.Event;
import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public abstract class CustomerEvent extends Event {
    protected Customer customer;
    public CustomerEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime);
    }


    public void execute(SupermarketState state){
        super.execute(state);
    }


}
