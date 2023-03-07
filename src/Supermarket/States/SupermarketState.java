package Supermarket.States;

import General.State;

public class SupermarketState extends State {
    final int maxCustomers = 100;
    final int maxOpenRegister = 10;
    final double openingTime = 00.00;
    final double closingTime = 22.00;
    private int customersInStore;
    private int customersInQueue;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;
    private int openRegisters;

    public SupermarketState(){
        super();
    }
}
