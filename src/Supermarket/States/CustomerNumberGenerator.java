package Supermarket.States;
/**
 * Generates numbers for each customer
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
public class CustomerNumberGenerator {
    private int currentCustomerNumber;

    /**
     * Instantiates CustomerNumberGenerator
     */
    public CustomerNumberGenerator(){
        this.currentCustomerNumber = 0;
    }

    /**
     * Gets a number
     * @return A number that is assigned to a customer
     */
    public int getCurrentCustomerNumber(){
        this.currentCustomerNumber += 1;
        return this.currentCustomerNumber - 1;
    }
}
