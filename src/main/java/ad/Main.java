package ad;

import ad.page4.sort_algos.*;

/**
 * Created by MattX7 on 21.10.2016.
 */
public class Main {
    static int n = 10000;
    static Integer[] elems = new Integer[n];
    static StopWatch stopWatch = new StopWatch();

    public static void bestCase(){
        for (Integer i = 0; i < n; i++) {
            elems[i] = i+1;
        }
    }

    public static void avgCase(){
        elems = StdIn.getNInts(n);
    }

    public static void worstCase(){
        int i=0;
        for (Integer j = n; j > 0; j--) {
            elems[i] = j;
            i++;
        }
    }

    public static void runBestCase(){
        System.out.println("=== Best Case ====");

        System.out.println("MergeSort:");
        bestCase();
        stopWatch.start();
        MergeSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();


        System.out.println("InsertionSort:");
        bestCase();
        stopWatch.start();
        InsertionSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();

        System.out.println("BubbleSort:");
        bestCase();
        stopWatch.start();
        BubbleSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();

        System.out.println("MaxSort:");
        bestCase();
        stopWatch.start();
        MaxSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();
    }

    public static void runAVGCase(){
        System.out.println("=== Average Case ====");

        System.out.println("MergeSort:");
        avgCase();
        stopWatch.start();
        MergeSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();


        System.out.println("InsertionSort:");
        avgCase();
        stopWatch.start();
        InsertionSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();

        System.out.println("BubbleSort:");
        avgCase();
        stopWatch.start();
        BubbleSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();

        System.out.println("MaxSort:");
        avgCase();
        stopWatch.start();
        MaxSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();
    }

    public static void runWorstCase(){
        System.out.println("=== Worst Case ====");

        System.out.println("MergeSort:");
        worstCase();
        stopWatch.start();
        MergeSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();


        System.out.println("InsertionSort:");
        worstCase();
        stopWatch.start();
        InsertionSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();

        System.out.println("BubbleSort:");
        worstCase();
        stopWatch.start();
        BubbleSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();

        System.out.println("MaxSort:");
        worstCase();
        stopWatch.start();
        MaxSort.sort(elems);
        System.out.println("Runtime: "+stopWatch.stop());
        System.out.println();
    }
    public static void main(String[] args) {
        runBestCase();
        runAVGCase();
        runWorstCase();

    }
}
