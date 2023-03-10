package Supermarket.States;

import Supermarket.FIFO;

public class CheckoutQueue extends FIFO {
    public CheckoutQueue(){
        super();
    }

    public void addCustomer(Customer customer){
        this.add(customer);
    }

    public Customer getFirstCustomer(){
        Customer customer = (Customer) super.first();
        this.removeFirst();
        return customer;
    }
}
