package ad.aufgabe1;

import java.util.LinkedList;

/**
 * Created by Neak on 03.10.2016.
 *
 */
public class QueueList<T> extends QueueADT<T> {

    private LinkedList<T> elements;
    private int capacity;

    public QueueList(int capacity){
        elements = new LinkedList<T>();
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T element) {
        if( this.count() < this.getLength())
            elements.add(element);
        else
            throw new IndexOutOfBoundsException("Queue is full");
    }

    @Override
    public T dequeue() {
        T first = elements.getFirst();
        if (first != null) {
            elements.removeFirst();
            return first;
        } else{
            throw new IndexOutOfBoundsException("Queue is empty");
        }
    }

    @Override
    public int count() {
        return this.elements.size();
    }

    @Override
    public int getLength() {
        return this.capacity;
    }

    @Override
    public Boolean isFull(){
        return this.count() == this.getLength();
    }

    @Override
    public Boolean isEmpty() {  return this.count() == 0; }

}







