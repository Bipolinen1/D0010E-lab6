package Supermarket.States;

import General.State;

public class SupermarketState extends State {

    final int maxCustomers;
    final int openRegisters;
    final CustomerNumberGenerator customerNumberGenerator;
    final ArrivalTime arrivalTime;
    final PickTime pickTime;
    final PayTime payTime;
    private int customersInStore = 0;
    private int customersInQueue = 0;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;
    private int unUsedRegisters; //lediga kassor
    private int UsedRegisters;  //upptagna kassor
    private double unUsedRegisterTime = 0;
    private double totalQueueTime = 0;
    private int ChangedRegisters;
    private boolean closed = true;

    private double lambda;
    private long seed;
    private double kMin;
    private double kMax;
    private double pMin;
    private double pMax;

    // Lambda är genomstnittliga antalet kunder på ett visst tidsintervall
    // Seed är ett tal som används vid slumpgenerering
    public SupermarketState(int maxCustomers, int maxOpenRegisters, double lambda, long seed, double kMin,
                            double kMax, double pMin, double pMax) {
        super();
        this.maxCustomers = maxCustomers;
        this.openRegisters = maxOpenRegisters;
        this.lambda = lambda;
        this.seed = seed;
        this.kMin = kMin;
        this.kMax = kMax;
        this.pMin = pMin;
        this.pMax = pMax;
        customerNumberGenerator = new CustomerNumberGenerator();
        arrivalTime = new ArrivalTime(lambda, seed);
        payTime = new PayTime(kMax, kMin, seed);
        pickTime = new PickTime(pMax, pMin, seed);
    }

    public int ChangedRegisters() {
        return unUsedRegisters - 1;  //vet ej om detta är rätt
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

    public void setCustomersInQueue() {
        customersInQueue = checkoutQueue.size();
    }

    public int getCustomersInQueue() {
        return customersInQueue;
    }

    public CheckoutQueue getCheckoutQueue() {
        return checkoutQueue;
    }

    public double getLambda() {
        return lambda;
    }

    public long getSeed() {
        return seed;
    }

    public double getkMin() {
        return kMin;
    }

    public double getkMax() {
        return kMax;
    }

    public double getpMin() {
        return pMin;
    }

    public double getpMax() {
        return pMax;
    }

    public int getunUsedRegisters() {
        return unUsedRegisters;
    }

    public double getUnUsedRegisterTime(){
        return unUsedRegisterTime;
    }

}