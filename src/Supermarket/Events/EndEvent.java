package Supermarket.Events;
import General.Event;
import General.EventQueue;
import General.State;
import Supermarket.States.SupermarketState;

public class EndEvent extends Event {
    public EndEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }
    public void execute(State state){
        super.execute(state);
        state.stop();
        state.update("End");
    }
}
