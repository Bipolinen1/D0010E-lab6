package Supermarket.States;

public class CustomerNumberGenerator {
    private int currentCustomerNumber;
    public CustomerNumberGenerator(){
        this.currentCustomerNumber = 0;
    }
    public int getCurrentCustomerNumber(){
        this.currentCustomerNumber += 1;
        return this.currentCustomerNumber - 1;
    }
}
