package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.PickTime;

public class ArrivalEvent extends CustomerEvent {
    public ArrivalEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    @Override
    public void execute() {
        // Todo Lägg till om stängt
        // Todo Fixa picktime istället för 0. Customer?

        if(state.getCustomersInStore() < state.getMaxCustomers()) {
            eventQueue.add(new PickEvent(eventQueue, 0, customer));
            if(!state.isClosed()){
                eventQueue.add(new ArrivalEvent(eventQueue, 0, state.createCustomer()));
            }
        }
        else {
            state.addMissedCustomer();

        }
    }
}
