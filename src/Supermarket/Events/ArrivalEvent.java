package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.PickTime;
import General.State;
import Supermarket.States.SupermarketState;

public class ArrivalEvent extends CustomerEvent {
    public ArrivalEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }


    public void execute(State state) {
        super.execute(state);
        System.out.println("arrivalTest");
        if(((SupermarketState)state).getCustomersInStore() < ((SupermarketState)state).getMaxCustomers()) {
            eventQueue.add(new PickEvent(eventQueue, ((SupermarketState)state).getArrivalTime(), customer, ((SupermarketState)state)));
            ((SupermarketState)state).addCustomerInStore();
            ((SupermarketState)state).setCurrentTime(((SupermarketState)state).getArrivalTime());
            if(!((SupermarketState)state).isClosed()){
                eventQueue.add(new ArrivalEvent(eventQueue, ((SupermarketState)state).getArrivalTime(),
                        ((SupermarketState)state).createCustomer(), ((SupermarketState)state)));
            }
            state.update("Arrival");
        }
        else {
            ((SupermarketState)state).addMissedCustomer();

        }
    }
}
