package General;

public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;


    public Event(EventQueue eventQueue, double eventTime){

    }
    public abstract void execute();
    public double getEventTime(){
        return this.eventTime;
    }
}
