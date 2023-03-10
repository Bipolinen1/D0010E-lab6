package General;

import java.util.ArrayList;

public class EventQueue extends ArrayList<Event>{
    public EventQueue(){
        super();
    }

    public void addEvent(Event event){
        System.out.println("Hej");
        if(this.isEmpty()){
            this.add(event);
        }
        else {
            for(int i = this.size() - 1; i >= 0; i--) {
                if (event.getEventTime() < this.get(i).getEventTime()) {
                    continue;
                } else if (i == 0) {
                    this.add(i, event);
                    break;
                }
                this.add(i, event);
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
