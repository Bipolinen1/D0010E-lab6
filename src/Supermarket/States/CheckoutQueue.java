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

    public Customer getCustomer(int i){
        Customer customer = (Customer) super.get(i);
        return customer;
    }

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
