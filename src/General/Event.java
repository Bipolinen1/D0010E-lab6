package General;

public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;
    protected State state;

    public Event(EventQueue eventQueue, double eventTime){

    }
    public abstract void execute();
    public double getEventTime(){
        return this.eventTime; // Test Ossian
    }
}
