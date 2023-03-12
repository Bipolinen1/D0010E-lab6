package General;
/**
 * General observer. Implements Observer
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    /**
     * Updates the view
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {

    }
}
