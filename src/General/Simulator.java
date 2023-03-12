package General;
/**
 * This class runs the simulation
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
public class Simulator {
    protected EventQueue eventQueue;
    protected State state;

    /**
     * Creates an instance of Simulator
     * @param eventQueue reference to the eventQueue
     * @param state the state
     */
    public Simulator(EventQueue eventQueue, State state){
        this.eventQueue = eventQueue;
        this.state = state;
    }

    /**
     * Runs the simulation until it is stopped
     */
    public void run(){
        while(!state.isStopped()){
            eventQueue.get(0).execute();
            eventQueue.removeEvent();
        }
    }
}
