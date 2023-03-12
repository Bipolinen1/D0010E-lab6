package Supermarket;
/**
 * A First in first out queue, is inherited by CheckoutQueue
 * @author Hampus Bensryd, Dominic Addo, Ossian Abrahamsson, Deborah Aittokallio
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO{
    private ArrayList<Object> queue;
    private String stringObjects;
    private int max = 0;

    /**
     * Instantiates FIFO
     */
    public FIFO(){
        this.queue = new ArrayList<>();

    }

    /**
     * Adds a object to the queue
     * @param o the object to be added
     */
    public void add(Object o) {
        queue.add(o);
        if(max < queue.size()){
            max += 1;
        }
    }

    /**
     * Gets an object from the queue
     * @param index the index of the object that should be returned
     * @return the object at index
     */
    public Object get(int index){
        return queue.get(index);
    }

    /**
     * Removes the first element in the queue
     * @throws NoSuchElementException
     */
    public void removeFirst() throws NoSuchElementException {
        if(queue.size() == 0){
            throw new NoSuchElementException();
        }
        queue.remove(0);
    }

    /**
     * Gets the first element in the list
     * @return the element at index 0
     * @throws NoSuchElementException
     */
    public Object first() throws NoSuchElementException {
        if(queue.size() == 0){
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }

    /**
     * Checks if the queue is empty
     * @return true or false depending on if the queue is empty or not
     */
    public boolean isEmpty() {
        if(queue.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Gets the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return queue.size();
    }


    @Override
    public boolean equals(Object f) throws ClassCastException{
        if(f.getClass() != this.getClass()){
            throw new ClassCastException();
        }
        FIFO fFifo = (FIFO) f;
        if(fFifo.size() == this.queue.size()){
            for(int i = 0; i < this.queue.size(); i++){
                if(fFifo.queue.get(i) == null && this.queue.get(i) != null ||
                        fFifo.queue.get(i) != null && this.queue.get(i) == null){
                    return false;
                }
                else if(fFifo.queue.get(i) == null && this.queue.get(i) == null){
                    continue;
                }
                else if(fFifo.queue.get(i) == (this.queue.get(i))){
                    continue;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the queue as a string. Isn't used
     * @return the queue as a string
     */
    @Override
    public String toString() {
        stringObjects = "";
        for(int i = 0; i < queue.size(); i++){
            stringObjects += "(" + String.valueOf(queue.get(i)) + ") ";
        }
        return "Queue: " + stringObjects;
    }
}
