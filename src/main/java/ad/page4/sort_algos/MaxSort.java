package ad.page4.sort_algos;

/**
 * Created by Neak on 20.10.2016.
 */
public class MaxSort {


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

    //
    // Test
    //

    public static void printArray(int[] elems) {
        for (int elem : elems) System.out.print(" " + elem);
        System.out.println();
    }

    public static void main(String argv[]) {
        Comparable[] elem = {5, 3, 2, 6, 9, 7, 5, 2};

        System.out.println(elem);
        sort(elem);
        System.out.println(elem);
    }
}

