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

    @Override
    public void execute(State state) {
        super.execute(state);
        if(((SupermarketState)state).getCustomersInStore() < ((SupermarketState)state).getMaxCustomers()) {
            eventQueue.addEvent(new PickEvent(eventQueue, ((SupermarketState)state).getPickTime(),
                    customer, ((SupermarketState)state)));
            ((SupermarketState)state).addCustomerInStore();
            if(!((SupermarketState)state).isClosed()){
                eventQueue.addEvent(new ArrivalEvent(eventQueue, ((SupermarketState)state).getArrivalTime(),
                        ((SupermarketState)state).createCustomer(), ((SupermarketState)state)));
            }
            state.update(this);
        }
        else {
            ((SupermarketState)state).addMissedCustomer();

        }
    }

    public String getName(){
        return "Arrival";
    }
}
