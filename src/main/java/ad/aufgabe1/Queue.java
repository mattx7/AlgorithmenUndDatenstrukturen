/*
 * ADP Aufgabe 1.1
 */
package ad.aufgabe1;

/**
 * FIFO-Queue als zyklisch arbeitenden Puffer mit beschränkter Größe.
 *
 */
interface Queue<T> {

    /**
     * Laufzeitanforderung: O(1)
     *
     * @return true if full
     */
    Boolean isFullADT();

    /**
     * Laufzeitanforderung: O(1)
     *
     * @return true if empty
     */
    Boolean isEmptyADT();

    /**
     * FIFO: First in first out
     * Laufzeitanforderung: O(1)
     *
     * @require size of queue != amount of Elems
     * @ensure size +1
     * @return next Element
     * @throws NullPointerException if nothing left to dequeue.
     */
    T dequeueADT() throws NullPointerException;

    /**
     * FIFO: First in first out
     * Laufzeitanforderung: O(1)
     *
     * @require input != null
     * @ensure elem added
     * @param elem element to insert
     * @throws IndexOutOfBoundsException no space left
     */
    void enqueueADT(T elem) throws IndexOutOfBoundsException;

    /**
     * Laufzeitanforderung: O(1)
     *
     * @return amount of Elements in the FIFO
     */
    int countADT();
}
