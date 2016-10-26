package ad.page4_nfa_sort.sort_algos;

import ad.helper.MyHelper;

/**
 * Created by MattX7 on 21.10.2016.
 */
public class BubbleSort {

    public static void sort(int[] x) {
        boolean unsorted = true;
        int temp;

        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < x.length - 1; i++)
                if (x[i] > x[i + 1]) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    unsorted = true;
                }
        }
    }

    public static void sort(Comparable[] x) {
        boolean unsorted = true;
        Comparable temp;

        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < x.length - 1; i++)
                if (x[i].compareTo(x[i + 1]) > 0) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    unsorted = true;
                }
        }
    }

    public static void main(String args[]) {
        Comparable[] elems = MyHelper.getRandomInts(10, 30);
        MyHelper.show(elems, "before");
        sort(elems);
        MyHelper.show(elems, "after");
    }
}
