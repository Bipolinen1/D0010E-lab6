package General;

public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;
    protected State state;

    public Event(EventQueue eventQueue, double eventTime, State state){
        this.state = state;
        this.eventTime = eventTime;
        this.eventQueue = eventQueue;
    }
    public void execute(){

    }
    public double getEventTime(){
        return this.eventTime;
    }

    public abstract String getName();
}
