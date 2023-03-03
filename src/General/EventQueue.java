package General;

import java.util.ArrayList;

public class EventQueue extends ArrayList<Event>{
    public EventQueue(){
        super();

    }
    public void addEvent(Event event){
        for(int i = this.size() - 1; i >= 0; i--){
            if(event.getEventTime() < this.get(i).getEventTime()){
                this.add(i, event);
            }
            public void Dominic(){

            }
            else if(i == this.size() - 1){
                this.add(event);
                break;
            }
            else{
                break;
            }
        }
    }


}
