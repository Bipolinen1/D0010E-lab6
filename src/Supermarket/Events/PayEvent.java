package Supermarket.Events;
/**
 * This keeps track of payments. It inherits CustomerEvent
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public class PayEvent extends CustomerEvent {
    /**
     *
     * Instansiates a cCustomerEvent
     * @param eventQueue reference to the eventQueue
     * @param eventTime the time the event occurs
     * @param customer the customer belonging to the event
     * @param state the state
     */
    public PayEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    /**
     * The effect of the event.
     */
    @Override
    public void execute() {
        super.execute();
        state.update(this);
        // Removes customers from the store and adds to paid
        ((SupermarketState)state).removeCustomerInStore();
        ((SupermarketState)state).addPaidCustomer();
        // Checks if the checkoutQueue is empty
        if(((SupermarketState)state).getCheckoutQueue().isEmpty()){
            // Customer occupies a register
            ((SupermarketState)state).setUnUsedRegisters(((SupermarketState)state).getUnUsedRegisters() + 1);
        }
        // Checks if checkoutQueue contains customers
        if(((SupermarketState)state).getCheckoutQueue().size() > 0){
            // Creates a future payEvent for the customer
            eventQueue.addEvent(new PayEvent(eventQueue,
                    ((SupermarketState)state).getPayTime(), ((SupermarketState)state).getCheckoutQueue().getFirstCustomer(),
                    ((SupermarketState)state)));
        }
    }

    /**
     * Gets the customer associated with the event
     * @return customer
     */
    public Customer getCustomer(){
        return this.customer;
    }

    /**
            * Returns what type of event it is
     * @return the name of the event
     */
    public String getName(){
        return "Pay";
    }
}
