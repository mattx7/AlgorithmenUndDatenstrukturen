package ad.page6_suchtbäume;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

/**
 * Created by MattX7 on 01.11.2016.
 * Generates a Dictionary with random amount elements
 */
public class Generator<T> {
    private static LinkedList<Double> usedKeys = new LinkedList<Double>();
    private final static Double maxKeyValue = 100.0;
    private static int n = 30;

    // === PUBLIC ===

    public static OurDictionary generate() {
        OurDictionary<Double, String> dict = new OurDictionary<Double, String>();
        _generate(dict, n);
        return dict;
    }

    public static void setN(int n) {
        Generator.n = n;
    }

    // === PRIVATE ===

    private static void _generate(OurDictionary<Double, String> dict, int n) {
        Double p = Math.random();
        Double q = Math.random();
        Double key = getNewKey();
        dict.put(key, key.toString());
        if (yesOrNo(p))
            key = getNewKey();
        dict.put(key, key.toString());
        if (yesOrNo(1 - p)) {
            dict.remove(getUsedKey());
            if (yesOrNo(q)) dict.remove(getUsedKey());
            key = getNewKey();
            if (yesOrNo(1 - p)) dict.put(key, key.toString());
        }
        if (n != 0)
            _generate(dict, n - 1);
    }

    @NotNull
    private static Boolean yesOrNo(Double x) {
        return x > 0.5;
    }

    @NotNull
    public static Double getNewKey() {
        Double key = Math.random() * maxKeyValue;
        usedKeys.add(key);
        return key;
    }

    @Nullable
    private static Double getUsedKey() {
        int size = usedKeys.size();
        if (size == 0)
            return null;
        else
            return usedKeys.get((int) (size * Math.random()));
    }

    // === MAIN ===

    public static void main(String[] args) {
        System.out.println(generate().size());
    }
}
