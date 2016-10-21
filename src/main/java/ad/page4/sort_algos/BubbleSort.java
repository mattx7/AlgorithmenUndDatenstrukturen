package ad.page4.sort_algos;

import ad.StdOut;

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

    // print array to standard output
    public static void show(Comparable[] elems) {
        for (Comparable elem : elems) {
            StdOut.println(elem);
        }
    }

    public static void main(String[] args) {
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        sort(liste);
        for (int i = 0; i < liste.length; i++)
            System.out.print(liste[i] + " ");
    }

}
