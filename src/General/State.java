package General;

import java.util.Observable;

public class State extends Observable{
    private double currentTime;
    private boolean stopped;

    public State(){}

    public double getCurrentTime(){
        return currentTime;
    }

    public void setCurrentTime(double time){
        if(time < this.getCurrentTime()){
            throw new RuntimeException("Can't go back in time");
        }
        currentTime = time;
    }

    public void stop(){
        stopped = true;
    }

}
