package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import General.State;
import Supermarket.States.SupermarketState;

public class PayEvent extends CustomerEvent {
    public PayEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    public void execute(State state) {
        super.execute(state);
        ((SupermarketState)state).removeCustomerInStore();
        ((SupermarketState)state).getUnUsedRegisters();

        if(((SupermarketState)state).getCustomersInQueue() < 0){
            ((SupermarketState)state).getCheckoutQueue().removeFirst();
            ((SupermarketState)state).getOpenRegisters();
        }else{
            //TODO Minska antal lediga kassor med 1
        }

        state.update("Pay");
    }
}
