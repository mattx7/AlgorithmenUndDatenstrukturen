package ad.blatt4.sort_algos;

/**
 * Created by MattX7 on 20.10.2016.
 */
public class InsertionSort {
    public static Comparable[] sort(Comparable[] elems) {
        for (int i = 1; i < elems.length; i++) {
            Comparable temp = elems[i];
            int j = i;
            while (j > 1 && elems[j-1].compareTo(temp) > 0) {
                elems[j] = elems[j-1];
                j--;
            }
            elems[j] = temp;
        }
        return elems;
    }
}
