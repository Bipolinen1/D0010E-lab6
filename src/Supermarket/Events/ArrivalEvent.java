package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.PickTime;
import General.State;
import Supermarket.States.SupermarketState;

public class ArrivalEvent extends CustomerEvent {
    public ArrivalEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }


    public void execute(SupermarketState state) {
        super.execute(state);
        if(state.getCustomersInStore() < state.getMaxCustomers()) {
            eventQueue.add(new PickEvent(eventQueue, state.getArrivalTime(), customer));
            state.addCustomerInStore();
            state.setCurrentTime(state.getArrivalTime());
            if(!state.isClosed()){
                eventQueue.add(new ArrivalEvent(eventQueue, state.getArrivalTime(), state.createCustomer()));
            }
            state.update();
        }
        else {
            state.addMissedCustomer();

        }
    }
}
