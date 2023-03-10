package General;
/**
 * Class for states that aren't Supermarket specific, Inherits Observable
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import java.util.Observable;

public class State extends Observable{
    protected double previousTime;
    protected double currentTime;
    protected boolean stopped;

    /**
     * Creates an instance of State, sets stopped to false
     */
    public State(){
        this.stopped = false;
    }

    /**
     * Returns the currentTime
     * @return currentTime
     */
    public double getCurrentTime(){
        return currentTime;
    }

    /**
     * Sets the current time
     * @param time the new time
     */
    public void setCurrentTime(double time){
        currentTime = time;
    }

    /**
     * Checks if the simulation is stopped
     * @return boolean stooped
     */
    public boolean isStopped(){
        return stopped;
    }

    /**
     * Stops the simulation
     */
    public void stop(){
        stopped = true;
    }

    /**
     * Updates the time and notifies observers
     * @param event the event that executes
     */
    public void update(Event event){
        this.previousTime = currentTime;
        this.setCurrentTime(event.getEventTime());
        this.setChanged();
        this.notifyObservers(event);
    }
}
