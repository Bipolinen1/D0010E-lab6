package General;
/**
 * General class that keeps track of when events should happen. It inherits arrayList
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import java.util.ArrayList;

public class EventQueue extends ArrayList<Event>{

    /**
     * Instantiates an EventQueue
     */
    public EventQueue(){
        super();
    }

    /**
     * Adds an event to the queue
     * @param event the event that should be added
     */
    public void addEvent(Event event){
        // If the queue is empty it adds the event
        if(this.isEmpty()){
            this.add(event);
        }
        else {
            // Loop goes through the queue comparing the time of Events
            for(int i = 0; i < this.size(); i++) {
                // If the eventTIme is smaller than the event time on position i, the event is added to position i
                if (event.getEventTime() < this.get(i).getEventTime()) {
                    this.add(i, event);
                    break;
                    // If the loop has gone through the entire queue, the event is added last
                } else if (i == this.size() - 1){
                    this.add(event);
                    break;
                }
            }
        }
    }

    /**
     * Removes the event on index 0 from the EventQueue
     */
    public void removeEvent(){
        this.remove(0);
    }


}
