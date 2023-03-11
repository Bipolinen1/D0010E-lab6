package Supermarket.Events;
/**
 * This class keeps track of customers picking. It inherits CustomerEvent
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.EventQueue;
import General.State;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public class PickEvent extends CustomerEvent {
    /**
     *
     * Creates an instance of PickEvent
     * @param eventQueue reference to the eventQueue
     * @param eventTime the time the event should execute
     * @param customer the customer
     * @param state the state
     */
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    @Override
    public void execute() {
        super.execute();
        state.update(this);
        // Adds a customer to the checkoutQueue
        ((SupermarketState)state).getCheckoutQueue().addCustomer(customer);
        // If the there is unused registers, a new payEvent is created for the customer, else adds queued customer
        if((((SupermarketState)state).getUnUsedRegisters() > 0)){
            ((SupermarketState)state).setUnUsedRegisters(((SupermarketState)state).getUnUsedRegisters() - 1);
            eventQueue.addEvent(new PayEvent(eventQueue,
                    ((SupermarketState)state).getPayTime(), ((SupermarketState)state).getCheckoutQueue().getFirstCustomer(),
                    ((SupermarketState)state)));
        }
        else{
            ((SupermarketState)state).addTotalQueuedCustomers();
        }
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public String getName(){
        return "Pick";
    }
}
