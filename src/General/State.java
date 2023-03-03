package General;

import java.util.Observable;

public class State extends Observable{
    private double currentTime;
    private boolean running;

    public double getCurrentTime(){
        return currentTime;
    }
}
