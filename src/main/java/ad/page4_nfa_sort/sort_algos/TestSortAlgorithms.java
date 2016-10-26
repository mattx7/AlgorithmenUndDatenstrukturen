package ad.page4_nfa_sort.sort_algos;

import ad.helper.MyHelper;
import ad.helper.StopWatch;

/**
 * Created by MattX7 on 21.10.2016.
 */
public class TestSortAlgorithms {
    private static int n = 10000;
    private static Integer[] elems = new Integer[n];
    private static StopWatch stopWatch = new StopWatch();

    private static void bestCase() {
        elems = MyHelper.getINCInts(n);
    }

    private static void avgCase() {
        elems = MyHelper.getRandomInts(n, 1000);
    }

    private static void worstCase() {
        elems = MyHelper.getDESCInts(n);
    }

    private static void runBestCase() {
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

    private static void runAVGCase() {
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

    private static void runWorstCase() {
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
