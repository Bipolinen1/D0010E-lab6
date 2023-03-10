package Supermarket.Events;
import General.Event;
import General.EventQueue;
import General.State;
import Supermarket.States.SupermarketState;

public class EndEvent extends Event {
    public EndEvent(EventQueue eventQueue, double eventTime, State state) {
        super(eventQueue, eventTime, state);
    }

    @Override
    public void execute(){
        super.execute();
        state.update(this);
        state.stop();
    }
    public String getName(){
        return "End";
    }
}
