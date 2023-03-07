package Supermarket.States;

import General.State;

public class SupermarketState extends State {
    final int maxCustomers;
    final int maxOpenRegisters;
    final double openingTime;
    final double closingTime;
    private int customersInStore = 0;
    private int customersInQueue = 0;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;
    private int openRegisters;
    private double unUsedRegisterTime = 0;
    private double totalQueueTime = 0;


    public SupermarketState(int maxCustomers, int maxOpenRegisters, double openingTime, double closingTime){
        super();
        this.maxCustomers = maxCustomers;
        this.maxOpenRegisters = maxOpenRegisters;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
}
