package General;

public abstract class Event {
    protected double eventTime;
    protected EventQueue eventQueue;
    protected State state;
    public abstract void execute();
}
