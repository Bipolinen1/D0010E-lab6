package Supermarket.States;

public class CustomerNumberGenerator {
    private int currentCustomerNumber;
    public CustomerNumberGenerator(){
        this.currentCustomerNumber = 1;
    }
    public int getCurrentCustomerNumber(){
        this.currentCustomerNumber += 1;
        return this.currentCustomerNumber - 1;
    }
}
