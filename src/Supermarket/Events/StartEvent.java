package Supermarket.Events;

import General.Event;
import General.EventQueue;
import General.State;
import Supermarket.States.*;


public class StartEvent extends Event{

    public StartEvent(EventQueue eventQueue, double eventTime, SupermarketState state){
        super(eventQueue, eventTime, state);
    }

    @Override
    public void execute(State state) {
        super.execute(state);
        state.update(this);
        eventQueue.addEvent(new ArrivalEvent(eventQueue, ((SupermarketState)state).getArrivalTime(),
                ((SupermarketState)state).createCustomer(), ((SupermarketState)state)));

    }

    public String getName(){
        return "Start";
    }
}
