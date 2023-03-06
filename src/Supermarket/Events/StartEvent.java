package Supermarket.Events;

import General.Event;
import General.EventQueue;

public class StartEvent extends Event{
    public StartEvent(EventQueue eventQueue, double eventTime) {
        super(eventQueue, eventTime);
    }

    @Override
    public void execute() {

    }
}
