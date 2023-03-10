package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import General.State;
import Supermarket.States.SupermarketState;

public class PayEvent extends CustomerEvent {
    public PayEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    @Override
    public void execute() {
        super.execute();
        state.update(this);
        ((SupermarketState)state).removeCustomerInStore();
        ((SupermarketState)state).addTotalCustomer();
        if(((SupermarketState)state).getCheckoutQueue().isEmpty()){
            ((SupermarketState)state).setUnUsedRegisters(((SupermarketState)state).getUnUsedRegisters() + 1);
        }

        if(((SupermarketState)state).getCheckoutQueue().size() > 0){
            eventQueue.addEvent(new PayEvent(eventQueue,
                    ((SupermarketState)state).getPayTime(), ((SupermarketState)state).getCheckoutQueue().getFirstCustomer(),
                    ((SupermarketState)state)));
        }
    }

    public Customer getCustomer(){
        return this.customer;
    }
    public String getName(){
        return "Pay";
    }
}
