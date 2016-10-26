package ad.page4_nfa_sort.sort_algos;

import ad.helper.MyHelper;

/**
 * Created by Neak on 20.10.2016.
 */
public class MaxSort {

    private MaxSort(){}

    public static void sort(int[] E) {
        for (int n = E.length ; n > 1 ; n--) {

            int maxIndex = 0;
            for (int i = 1 ; i < n ; i++)
                if (E[maxIndex] < E[i])
                    maxIndex = i;

            // Byt rundt på E[maxIndex] og E[n-1]
            int tmp = E[maxIndex];
            E[maxIndex] = E[n-1];
            E[n-1] = tmp;
        }
    }

    public static void sort(Comparable[] elems) {
        for (int n = elems.length; n > 1; n--) {

            int maxIndex = 0;
            for (int i = 1; i < n; i++)
                if (elems[maxIndex].compareTo(elems[i]) < 0)
                    maxIndex = i;
            
            Comparable tmp = elems[maxIndex];
            elems[maxIndex] = elems[n - 1];
            elems[n - 1] = tmp;
        }
    }

    public static void main(String args[]) {
        Comparable[] elems = MyHelper.getRandomInts(10, 30);
        MyHelper.show(elems, "before");
        sort(elems);
        MyHelper.show(elems, "after");
    }
}

