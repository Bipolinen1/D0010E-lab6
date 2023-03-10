package Supermarket.Events;

import General.EventQueue;
import General.State;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public class PickEvent extends CustomerEvent {
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    @Override
    public void execute() {
        super.execute();
        state.update(this);
        ((SupermarketState)state).getCheckoutQueue().addCustomer(customer);
        if((((SupermarketState)state).getUnUsedRegisters() > 0)){
            ((SupermarketState)state).setUnUsedRegisters(((SupermarketState)state).getUnUsedRegisters() - 1);
            eventQueue.addEvent(new PayEvent(eventQueue,
                    ((SupermarketState)state).getPayTime(), ((SupermarketState)state).getCheckoutQueue().getFirstCustomer(),
                    ((SupermarketState)state)));
        }
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public String getName(){
        return "Pick";
    }
}
