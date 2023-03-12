package General;
/**
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import java.util.ArrayList;

public class EventQueue extends ArrayList<Event>{
    public EventQueue(){
        super();
    }

    public void addEvent(Event event){
        if(this.isEmpty()){
            this.add(event);
        }
        else {
            for(int i = 0; i < this.size(); i++) {
                if (event.getEventTime() < this.get(i).getEventTime()) {
                    this.add(i, event);
                    break;
                } else if (i == this.size() - 1){
                    this.add(event);
                    break;
                }
            }
        }
    }

    public Event getNextEvent(){
         Event event = this.get(0);
         this.remove(0);
         return event;
    }

    public void removeEvent(){
        this.remove(0);
    }


}
