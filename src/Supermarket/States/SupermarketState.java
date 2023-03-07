package Supermarket.States;

import General.State;

public class SupermarketState extends State {
    final int maxCustomers;
    final int maxOpenRegisters;
    final double openingTime;
    final double closingTime;
    final CustomerNumberGenerator customerNumberGenerator;

    //TODO Avmarkera och lägg till i konstruktor när klasserna är färdiga
    /*final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;*/
    private int customersInStore = 0;
    private int customersInQueue = 0;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;
    private int openRegisters;
    private double unUsedRegisterTime = 0;
    private double totalQueueTime = 0;
    private boolean closed;


    public SupermarketState(int maxCustomers, int maxOpenRegisters, double openingTime, double closingTime){
        super();
        this.maxCustomers = maxCustomers;
        this.maxOpenRegisters = maxOpenRegisters;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        customerNumberGenerator = new CustomerNumberGenerator();
    }
    public Customer createCustomer(){
        return new Customer(customerNumberGenerator.getCurrentCustomerNumber());
    }
    public int getMaxCustomers(){
        return maxCustomers;
    }

    public int getCustomersInStore(){
        return customersInStore;
    }
    public void addMissedCustomer(){
        missedCustomers += 1;
    }
    public void addCustomerInStore(){
        customersInStore += 1;
    }

    public void removeCustomerInStore(){
        customersInStore -= 1;
    }

    public boolean isClosed(){
        return closed;
    }

    public void close(){
        closed = true;
    }
}
