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
    }

    @Override
    public void execute(State state){
        super.execute(state);
    }


}
