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
            eventQueue.get(0).execute(state);
            eventQueue.remove(0);
        }
    }
}
