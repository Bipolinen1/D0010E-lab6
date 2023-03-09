package Supermarket.Events;

import General.EventQueue;
import Supermarket.States.Customer;
import Supermarket.States.SupermarketState;

public class PickEvent extends CustomerEvent {
    public PickEvent(EventQueue eventQueue, double eventTime, Customer customer) {
        super(eventQueue, eventTime, customer);
    }

    public void execute(SupermarketState state) {
        super.execute(state);
        state.getOpenRegisters();
        state.ChangedRegisters(); //Skapade en metod som retunerar I SuperMarketState unUsedRegisters och minskar det med 1
        state.update();

    }
}
