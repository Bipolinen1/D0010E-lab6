package General;

import java.util.Observable;

public class State extends Observable{
    private double currentTime;
    protected boolean stopped;

    public State(){
        this.stopped = false;
    }

    public double getCurrentTime(){
        return currentTime;
    }

    public void setCurrentTime(double time){
        if(time < this.getCurrentTime()){
            throw new RuntimeException("Can't go back in time");
        }
        currentTime = time;
    }
    public boolean isStopped(){
        return stopped;
    }

    public void stop(){
        stopped = true;
    }

    //TODO Skriv en metod update som ändrar tid och meddelar observers
    public void update(){
        setChanged();
        notifyObservers();
    }
}
