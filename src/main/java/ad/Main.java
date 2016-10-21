package ad;

import ad.page4.sort_algos.BubbleSort;
import ad.page4.sort_algos.InsertionSort;
import ad.page4.sort_algos.MaxSort;
import ad.page4.sort_algos.MergeSort;

/**
 * Created by MattX7 on 21.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] a = StdIn.getNInts(118336);
//        int[] b = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            b[i]= a[i];
//        }

        System.out.println("MergeSort:");
        StopWatch stopMerge = new StopWatch();
        stopMerge.start();
        MergeSort.sort(a);
//        MergeSort.show(a);
        System.out.println("Runtime: "+stopMerge.stop());
        System.out.println();

        System.out.println("InsertionSort:");
        StopWatch stopInsertion = new StopWatch();
        stopInsertion.start();
        InsertionSort.sort(a);
//        InsertionSort.show(a);
        System.out.println("Runtime: "+stopInsertion.stop());
        System.out.println();

        System.out.println("BubbleSort:");
        StopWatch stopBubble = new StopWatch();
        stopBubble.start();
        BubbleSort.sort(a);
//        BubbleSort.show(a);
        System.out.println("Runtime: "+stopBubble.stop());
        System.out.println();

        System.out.println("MaxSort:");
        StopWatch stopMax = new StopWatch();
        stopMax.start();
        MaxSort.sort(a);
//        MaxSort.show(a);
        System.out.println("Runtime: "+stopMax.stop());
        System.out.println();

    }
}
