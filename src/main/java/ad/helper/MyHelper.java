package ad.helper;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by MattX7 on 26.10.2016.
 * Static helper methods
 */
public class MyHelper {

    /**
     * Random numbers under given max.
     *
     * @param n   amount of numbers
     * @param max biggest number
     * @return Array of ints
     */
    public static Integer[] getRandomInts(int n, int max) {
        Integer[] ints = new Integer[n];
        Random rn = new Random();
        int i = 0;
        while (i < n) {
            ints[i] = rn.nextInt(max) + 1;
            i++;
        }
        return ints;
    }

    /**
     * Sorted 1...n; Increasing
     *
     * @param n amount of numbers
     * @return Array of ints
     */
    public static Integer[] getINCInts(int n) {
        Integer[] ints = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

    /**
     * Sorted 1...n; Descending
     *
     * @param n amount of numbers
     * @return Array of ints
     */
    public static Integer[] getDESCInts(int n) {
        Integer[] ints = new Integer[n];
        int i = 0;
        for (int j = n; j > 0; j--) {
            ints[i] = j;
            i++;
        }
        return ints;
    }

    /**
     * Print elems
     *
     * @param elems get printed
     */
    public static void show(Comparable[] elems) {
        System.out.println(Arrays.toString(elems));
    }

    /**
     * Print elems
     *
     * @param elems get printed
     */
    public static void show(Comparable[] elems, String msg) {
        System.out.println("================ " + msg + " ================");
        show(elems);
    }
}
