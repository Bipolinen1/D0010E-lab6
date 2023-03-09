package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import General.State;
import Supermarket.States.SupermarketState;

public class PayEvent extends CustomerEvent {
    public PayEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    public void execute(SupermarketState state) {
        super.execute(state);
        state.removeCustomerInStore();
        state.getUnUsedRegisters();

        if(state.getCustomersInQueue() < 0){
            state.getCheckoutQueue().removeFirst();
            state.getOpenRegisters();
        }else{
            //TODO Minska antal lediga kassor med 1
        }

        state.update();
    }
}
