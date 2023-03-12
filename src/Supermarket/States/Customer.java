package Supermarket.States;
/**
 * Creates customers
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
public class Customer {

    private int customerNumber;

    /**
     * Instantiates a Customer
     * @param customerNumber the number for the customer
     */
    public Customer(int customerNumber){
        this.customerNumber = customerNumber;
    }

    /**
     * gets the number for the customer
     * @return the numbe rof the customer
     */
    public int getCustomerNumber(){
        return customerNumber;
    }

}
