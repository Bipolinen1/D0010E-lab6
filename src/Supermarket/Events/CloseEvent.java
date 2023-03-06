package Supermarket.Events;

import General.State;
import General.Event;
import General.EventQueue;

public class CloseEvent extends Event{
    public CloseEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }

    @Override
    public void execute() {
        for(int i = 0; i < eventQueue.size(); i++){
            if(eventQueue.get(i) instanceof ArrivalEvent){
                eventQueue.remove(i);
            }
        }
        if(eventQueue.isEmpty()){
            state.stop();
        }

    }
}
