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

    /**
     * The effect of the event
     */
    public void execute(){

    }

    /**
     * gets the time for the event
     * @return evenTime
     */
    public double getEventTime(){
        return this.eventTime;
    }

    /**
     * Abstract class for getName. Is used in other events
     */
    public abstract String getName();
}
