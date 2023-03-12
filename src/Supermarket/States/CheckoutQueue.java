package Supermarket.States;
/**
 * Keeps track of queuing customers
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import Supermarket.FIFO;

public class CheckoutQueue extends FIFO {
    /**
     * Creates an instance of CheckoutQueue
     */
    public CheckoutQueue(){
        super();
    }

    /**
     * Adds a customer to the checkout queue
     * @param customer the customer that should be added
     */
    public void addCustomer(Customer customer){
        this.add(customer);
    }

    /**
     * gets the customer at index 0
     * @return the customer at index 0
     */
    public Customer getFirstCustomer(){
        Customer customer = (Customer) super.first();
        this.removeFirst();
        return customer;
    }

    /**
     * gets a customer at given index
     * @param i index to get customer from
     * @return the customer at index i
     */
    public Customer getCustomer(int i){
        Customer customer = (Customer) super.get(i);
        return customer;
    }

    /**
     * Converts the queue to string
     * @return the queue as a string
     */
    @Override
    public String toString() {
        String string = "[";
        for(int i = 0; i < this.size(); i++){
            string += String.valueOf(this.getCustomer(i).getCustomerNumber());
            if(i < this.size() - 1){
                string += ", ";
            }
        }
        return string + "]";
    }
}
