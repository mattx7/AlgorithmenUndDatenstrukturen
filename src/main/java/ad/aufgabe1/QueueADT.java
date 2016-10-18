package ad.aufgabe1;

/**
 * Created by MattX7 on 24.09.2016.
 * Abstract Queue
 */
abstract class QueueADT<T> implements Queue<T> {

    // ================== ADT-Methods ============================

    /**
     * Laufzeitanforderung: O(1)
     *
     * @return true if full
     */
    public Boolean isFullADT() {
        return isFull();
    }


    /**
     * Laufzeitanforderung: O(1)
     *
     * @return true if empty
     */
    public Boolean isEmptyADT() {
        return isEmpty();
    }


    /**
     * FIFO: First in first out
     * Laufzeitanforderung: O(1)
     *
     * @require size of queue != amount of Elems
     * @ensure size +1
     * @return next Element
     * @throws NullPointerException if nothing left to dequeue.
     */
    public T dequeueADT() throws NullPointerException {
        int preCount = countADT();
        // Precondition
        assert preCount != 0 : "No space left";
        // Implementation
        T elem = dequeue();
        // Postcondition
        assert countADT() == preCount - 1 : "Elem not added";

        return elem;
    }


    /**
     * FIFO: First in first out
     * Laufzeitanforderung: O(1)
     *
     * @require input != null
     * @ensure elem added
     * @param elem element to insert
     * @throws IndexOutOfBoundsException no space left
     */
    public void enqueueADT(T elem) throws IndexOutOfBoundsException {
        int preCount = count();
        // Precondition
        assert elem != null : "Not null!";
        assert getLength() != preCount : "Is already Full";
        // Implementation
        enqueue(elem);
        // Postcondition
        assert countADT() == preCount + 1 : "Elem not added";
    }

    /**
     * Laufzeitanforderung: O(1)
     *
     * @return amount of Elements in the FIFO
     */
    public int countADT() {
        return count();
    }

    // ================== For implementation ============================

    Boolean isFull() {
        return null;
    }


    Boolean isEmpty() {
        return null;
    }


    T dequeue() throws NullPointerException {
        return null;

    }


    void enqueue(T elem) throws IndexOutOfBoundsException {
    }


    int count() {
        return 0;
    }


    int getLength() {
        return 0;
    }


}
