package Supermarket.States;
/**
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
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
    private int totalCustomers = 0;
    private CheckoutQueue checkoutQueue;
    private int payedCustomers = 0;
    private int missedCustomers = 0;
    private int unUsedRegisters; //lediga kassor
    private double lastToPay;
    private double unUsedRegisterTime = 0;
    private double totalQueueTime = 0;
    private double lastPayTime = 0;

    private boolean closed;
    private double lambda;
    private long seed;
    private double kMin;
    private double kMax;
    private double pMin;
    private double pMax;

    public int totalQueuedCustomers = 0;

    /**
     * Creates an instance of SupermarketState.
     * @param maxCustomers the max number of customers.
     * @param maxOpenRegisters the max number of registers.
     * @param lambda is the rate of customers arriving.
     * @param seed is the number used for selective randomising.
     * @param kMin minimum value that pay time can attain.
     * @param kMax maximum value that pay time can attain.
     * @param pMin minimum value that pick time can attain.
     * @param pMax maximum value that pick time can attain.
     */
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
        checkoutQueue = new CheckoutQueue();
        unUsedRegisters = maxOpenRegisters;
    }

    /**
     *  createCustomer() creates and returns a new customer with a new customer number.
     */
    public Customer createCustomer() {
        return new Customer(customerNumberGenerator.getCurrentCustomerNumber());
    }

    /**
     *  @return the maximum number of customers.
     */
    public int getMaxCustomers() {
        return maxCustomers;
    }

    /**
     *  @return the number of customers in the store.
     */
    public int getCustomersInStore() {
        return customersInStore;
    }

    /**
     *  addMissedCustomer() adds one to the total number of missed customers.
     */
    public void addMissedCustomer() {
        missedCustomers += 1;
    }

    /**
     *  addCustomerInStore() adds one to the total number of customers in the store and how many in total.
     */
    public void addCustomerInStore() {
        customersInStore += 1;
        totalCustomers += 1;
    }


    /**
     *  removeCustomerInStore() removes one from how many customers there is in the store.
     */
    public void removeCustomerInStore() {
        customersInStore -= 1;

    }

    /**
     *  @return a true or false depending on if the store is closed or not.
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     *  close() sets the varibale close to true meaning that the store is now considerd closed.
     */
    public void close() {
        closed = true;
    }

    /**
     *  open() sets the varibale open to true meaning that the store is now considerd opened.
     */
    public void open(){
        closed = false;
    }


    /**
     *  @return  time of a customer's arrival.
     */
    public double getArrivalTime() {
        return arrivalTime.calculateArrivalTime(getCurrentTime());
    }

    /**
     *  @return the number of registers.
     */
    public int getOpenRegisters() {
        return openRegisters;
    }


    /**
     *  setUnUsedRegisters() sets the number of unused registers to amount.
     * @param amount the amount that will dictate how many unused registers there are.
     */
    public void setUnUsedRegisters(int amount){
        unUsedRegisters = amount;
    }

    /**
     *  @return  the number of unused registers.
     */
    public int getUnUsedRegisters() {
        return unUsedRegisters;
    }

    /**
     *  addTotalQueuedCustomers() adds one to the number of costumers that has queued.
     */
    public void addTotalQueuedCustomers(){
        totalQueuedCustomers += 1;
    }

    /**
     *  @return the check out queue.
     */
    public CheckoutQueue getCheckoutQueue() {
        return checkoutQueue;
    }

    /**
     *  @return  the check out queue in form of a string.
     */
    public String getCheckOutQueueString(){
        return checkoutQueue.toString();
    }


    /**
     *  @return  the number dictating how often customers arrives.
     */
    public double getLambda(){
        return lambda;
    }

    /**
     *  @return the current seed used for random.
     */
    public long getSeed() {
        return seed;
    }


    /**
     *  @return  the minimum value that pay time can get.
     */
    public double getkMin() {
        return kMin;
    }

    /**
     *  @return  the maximum value that pay time can get.
     */
    public double getkMax() {
        return kMax;
    }

    /**
     *  @return  the minimum value that pick time can get.
     */
    public double getpMin(){
        return pMin;
    }

    /**
     *  @return  the maximum value that pick time can get.
     */
    public double getpMax() {
        return pMax;
    }

    /**
     * @return the total number of customers that was missed.
     */
    public int getMissedCustomers() {
        return missedCustomers;
    }

    /**
     *  @return the total number of customers that has payed.
     */
    public int getPayedCustomers() {
        return payedCustomers;
    }

    /**
     *  @return the total number of customers that are currently queueing so long the queue
     *  is not empty.
     */
    public int getCurrentlyQueuedCustomers() {
        if(checkoutQueue.isEmpty()){
            return 0;
        }
        return checkoutQueue.size();
    }

    /**
     *  @return  the total number of customers that has ever queued.
     */
    public int getCustomersThatQueued(){
        return totalQueuedCustomers;
    }

    /**
     *  @return  the total time that registers has been unused.
     */
    public double getUnUsedRegisterTime(){
        return unUsedRegisterTime;
    }


    /**
     *  addTotalCustomer() adds one to the total customers that has ever arrived.
     */
    public void addTotalCustomer(){
        this.totalCustomers += 1;
    }

    /**
     *  updateTimeOfQueuedCustomers() calculates the total time of queued customers by taking
     *  the diffrence in time frame between last call and current call times the number of customers in the queue.
     *  so long that there are at least one customer in the queue.
     */
    private void updateTimeOfQueuedCustomers() {
        if(!checkoutQueue.isEmpty()) {
            totalQueueTime += (currentTime - previousTime) * checkoutQueue.size();
        }
    }

    /**
     *  updateUnUsedRegisterTime() calculates the total unused register time by taking
     *  the diffrence in time frame between last call and current call time the number of unused registers.
     *  so long that there are at least  1 unused register.
     */
    private void updateUnUsedRegisterTime() {
        if(unUsedRegisters != 0) {
            unUsedRegisterTime += (currentTime - previousTime) * unUsedRegisters;
        }
    }

    /**
     *  updateT() calls updateUnUsedRegisterTime() and updateTimeOfQueuedCustomers()
     *  to update the time of queued customers and unused registers.
     */
    public void updateT() {
        updateUnUsedRegisterTime();
        updateTimeOfQueuedCustomers();
    }

    /**
     *  @return  the total time customers has queued.
     */
    public double getTimeOfQueuedCustomers(){
        return totalQueueTime;
    }

    /**
     * @return  the total number of customers that has arrived.
     */
    public int getTotalCustomers() {
        return totalCustomers;
    }

    /**
     * @return  the time of pick for a customer, by calling calculatePayTime with the parameter currentTime.
     */
    public double getPickTime() {
        return pickTime.calculatePickTime(currentTime);
    }

    /**
     * @return the time of payment for a customer, by calling calculatePayTime with the parameter currentTime.
     */
    public double getPayTime(){
        return payTime.calculatePayTime(currentTime);
    }

    /**
     * addPaidCustomer() Adds +1 to the counter of how many has payed,
     */
    public void addPaidCustomer(){
        payedCustomers += 1;
    }

    /**
     * setLastToPay() Sets the time of when the latest payment happened.
     */
    public void setLastToPay() {
        lastToPay = currentTime;
    }

    /**
     *  @return the time of the last pay event.
     */
    public double getLastToPay() {
        return lastToPay;
    }


}