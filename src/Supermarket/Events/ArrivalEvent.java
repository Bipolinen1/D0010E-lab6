package Supermarket.Events;
/**
 * This class is used for keeping track of arrivals
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.PickTime;
import General.State;
import Supermarket.States.SupermarketState;

public class ArrivalEvent extends CustomerEvent {
    /**
     * The constructor creates an instance of ArrivalEvent
     *
     * @param eventQueue a reference to the eventQueue
     * @param eventTime the time the event occurs
     * @param customer the customer associated with the event
     * @param state the state
     * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
     */
    public ArrivalEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    @Override
    public void execute() {
        super.execute();
        state.update(this);
        // Executes if supermarket is open
        if(!((SupermarketState)state).isClosed()){
            // Checks if the store is full
            if(((SupermarketState)state).getCustomersInStore() < ((SupermarketState)state).getMaxCustomers()) {
                // Adds a new pickEvent for the customer
                eventQueue.addEvent(new PickEvent(eventQueue, ((SupermarketState)state).getPickTime(),
                        customer, ((SupermarketState)state)));
                ((SupermarketState)state).addCustomerInStore();

                }
            else {
                // If store was full adds missed customer
                ((SupermarketState)state).addMissedCustomer();
                ((SupermarketState)state).addTotalCustomer();
            }
            // Adds an ArrivalEvent for the next customer
            eventQueue.addEvent(new ArrivalEvent(eventQueue, ((SupermarketState)state).getArrivalTime(),
                    ((SupermarketState)state).createCustomer(), ((SupermarketState)state)));
        }
    }
    // Returns the customer
    public Customer getCustomer(){
        return this.customer;
    }

    // Returns what type of event it is
    public String getName(){
        return "Arrival";
    }
}
