package General;

public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;


    public Event(EventQueue eventQueue, double eventTime){

    }
    public  void execute(State state){

    }
    public double getEventTime(){
        return this.eventTime;
    }
}
