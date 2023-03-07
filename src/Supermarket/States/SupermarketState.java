package Supermarket.States;

import General.State;

public class SupermarketState extends State {
    private int customersInStore;
    private int customersInQueue;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;

    public SupermarketState(){
        super();
    }
}
