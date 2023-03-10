package General;

public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;
    protected State state;

    public Event(EventQueue eventQueue, double eventTime, State state){
        this.state = state;
        this.eventQueue = eventQueue;
    }
    public void execute(State state){
        System.out.println("eventTest");
    }
    public double getEventTime(){
        return this.eventTime;
    }
}
