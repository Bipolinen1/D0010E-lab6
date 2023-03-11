package Supermarket;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO{
    private ArrayList<Object> queue;
    private String stringObjects;
    private int max = 0;

    public FIFO(){
        this.queue = new ArrayList<>();

    }

    public void add(Object o) {
        queue.add(o);
        if(max < queue.size()){
            max += 1;
        }
    }

    public Object get(int index){
        return queue.get(index);
    }

    public void removeFirst() throws NoSuchElementException {
        if(queue.size() == 0){
            throw new NoSuchElementException();
        }
        queue.remove(0);
    }

    public Object first() throws NoSuchElementException {
        if(queue.size() == 0){
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }

    public int maxSize() {
        return max;
    }

    public boolean isEmpty() {
        if(queue.size() == 0){
            return true;
        }
        return false;
    }

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


    @Override
    public String toString() {
        stringObjects = "";
        for(int i = 0; i < queue.size(); i++){
            stringObjects += "(" + String.valueOf(queue.get(i)) + ") ";
        }
        return "Queue: " + stringObjects;
    }
}
