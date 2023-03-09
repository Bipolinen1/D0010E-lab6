package General;

public class Simulator {
    protected EventQueue eventQueue;
    protected State state;
    public Simulator(EventQueue eventQueue, State state){
        this.eventQueue = eventQueue;
        this.state = state;
    }
    public void run(){
        System.out.println("hej");
        while(!state.isStopped()){
            System.out.println("hhhhh");
            eventQueue.get(0).execute(state);
            eventQueue.remove(0);

        }
    }

}
