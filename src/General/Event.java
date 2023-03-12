package General;
/**
 * General class for events, all other events inherit this class
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;
    protected State state;

    /**
     * Instantiates a Event
     * @param eventQueue reference to the eventQueue
     * @param eventTime the time the vent happens
     * @param state the state
     */
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
