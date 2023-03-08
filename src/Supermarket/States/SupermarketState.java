package Supermarket.States;

import General.State;

public class SupermarketState extends State {
    final int maxCustomers;
    final int maxOpenRegisters;
    final double openingTime;
    final double closingTime;
    final CustomerNumberGenerator customerNumberGenerator;
    final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private int customersInStore = 0;
    private int customersInQueue = 0;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;
    private int openRegisters;
    private int unUsedRegisters;
    private double unUsedRegisterTime = 0;
    private double totalQueueTime = 0;
    private boolean closed;

    // Lambda är genomstnittliga antalet kunder på ett visst tidsintervall
    // Seed är ett tal som används vid slumpgenerering
    public SupermarketState(int maxCustomers, int maxOpenRegisters, double openingTime, double closingTime,
                            double lambda, long seed, double kMin, double kMax, double pMin, double pMax) {
        super();
        this.maxCustomers = maxCustomers;
        this.maxOpenRegisters = maxOpenRegisters;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        customerNumberGenerator = new CustomerNumberGenerator();
        arrivalTime = new ArrivalTime(lambda, seed);
        payTime = new PayTime(kMax, kMin, seed);
        pickTime = new PickTime(pMax, pMin, seed);
    }

    public Customer createCustomer() {
        return new Customer(customerNumberGenerator.getCurrentCustomerNumber());
    }

    public int getMaxCustomers() {
        return maxCustomers;
    }

    public int getCustomersInStore() {
        return customersInStore;
    }

    public void addMissedCustomer() {
        missedCustomers += 1;
    }

    public void addCustomerInStore() {
        customersInStore += 1;
    }

    public void removeCustomerInStore() {
        customersInStore -= 1;
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() {
        closed = true;
    }

    public double getArrivalTime() {
        return arrivalTime.calculateArrivalTime(getCurrentTime());
    }

    public int getOpenRegisters() {
        return openRegisters;
    }

    public int getUnUsedRegisters() {
        return unUsedRegisters;
    }

    public void setCustomersInQueue(){
        customersInQueue = checkoutQueue.size();
    }

    public int getCustomersInQueue() {
        return customersInQueue;
    }

    public CheckoutQueue getCheckoutQueue() {
        return checkoutQueue;
    }

}