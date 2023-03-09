package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public class PickEvent extends CustomerEvent {
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    public void execute(SupermarketState state) {
        super.execute(state);
        if(state.getUnUsedRegisters() > 0){
            state.removeCustomerInStore();
        }
        else{
            state.getCheckoutQueue().addCustomer(customer);
            state.setCustomersInQueue();
        }


        state.update();
    }
}
