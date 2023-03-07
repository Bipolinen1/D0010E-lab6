package Supermarket.States;

public class Customer {
    private int customerNumber = 0;

    public Customer(int customerNumber){
        this.customerNumber = customerNumber;
        customerNumber += 1;
    }
    public int getCustomerNumber(){
        return this.customerNumber;
    }
}
