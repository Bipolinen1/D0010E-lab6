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
    public void execute(State state) {
        super.execute(state);
        state.update(this);
        ((SupermarketState)state).removeCustomerInStore();
        ((SupermarketState)state).addTotalCustomer();

        if(((SupermarketState)state).getCustomersInQueue() < 0){
            ((SupermarketState)state).getCheckoutQueue().removeFirst();
            ((SupermarketState)state).getOpenRegisters();
        }else{
            //TODO Minska antal lediga kassor med 1
        }
    }

    public String getName(){
        return "Pay";
    }
}
