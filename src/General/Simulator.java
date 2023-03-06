package General;

public class Simulator {
    protected EventQueue eventQueue;
    protected State state;
    public Simulator(EventQueue eventQueue, State state){
        this.eventQueue = eventQueue;
        this.state = state;
    }
    public void run(){
        while(!state.isStopped()){
            Event event = eventQueue.get(0);
            eventQueue.remove(0);
            event.execute();
        }
    }

}
