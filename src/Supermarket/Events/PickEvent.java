package Supermarket.Events;

import General.EventQueue;
import General.State;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public class PickEvent extends CustomerEvent {
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer, SupermarketState state) {
        super(eventQueue, eventTime, customer, state);
    }

    @Override
    public void execute(State state) {
        super.execute(state);
        if(((SupermarketState)state).getOpenRegisters() == 0){
            ((SupermarketState)state).getCheckoutQueue().addCustomer(customer);
        }
        else{
            eventQueue.addEvent(new PayEvent(eventQueue,
                    ((SupermarketState)state).getPayTime(), customer, ((SupermarketState)state)));
        }
        ((SupermarketState)state).ChangedRegisters(); //Skapade en metod som retunerar I SuperMarketState unUsedRegisters och minskar det med 1
        state.update(this);

    }

    public String getName(){
        return "Pick";
    }
}
