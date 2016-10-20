package ad.page1;

/**
 * Created by MattX7 on 03.10.2016.
 *
 */
public class QueueArray<T> extends QueueADT<T> {

    private int firstIndex;
    private int successorIndex;
    private boolean empty;
    private final T[] queue;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int length){
        queue = (T[]) new Object[length];
        this.capacity   = length;
        this.firstIndex     = 0;
        this.successorIndex = 0;
        this.empty = true;
    }

    // ====================== PUBLIC ===========================

    @Override
    public T dequeue() throws NullPointerException {
        T elem = queue[firstIndex];
        this.queue[firstIndex] = null;
        this.firstIndex = this.succ(firstIndex);
        if (firstIndex==successorIndex)
            this.empty = true;
        return elem;
    }

    @Override
    public void enqueue(T elem) throws IndexOutOfBoundsException {
        this.queue[successorIndex] = elem;
        this.empty = false;
        this.successorIndex = this.succ(successorIndex);
    }

    @Override
    int count() {
        if (empty)
            return 0;
        else if(successorIndex > firstIndex)
            return (successorIndex - firstIndex);
        else
            return (successorIndex + (capacity-firstIndex));
    }

    @Override
    public Boolean isFull() {
        return (this.count() == capacity);
    }

    @Override
    public Boolean isEmpty() {
        return this.count() == 0;
    }

    @Override
    public int getLength(){ return queue.length; }

    // ============================== PRIVATE ===========================

    /**
     * @param index actual
     * @return successor index
     */
    private int succ(int index){
        int i = (index + 1) % this.capacity;
        return i;
    }

    /**
     * @param index actual
     * @return predecessor index
     */
    private int pred(int index){
        if (index==0)
            return 5;
        else
            return (index-1);
    }
}
