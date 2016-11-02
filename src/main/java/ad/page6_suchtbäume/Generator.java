package ad.page6_suchtbäume;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

/**
 * Created by MattX7 on 01.11.2016.
 * Generates a Dictonary with random elements
 */
public class Generator<T> {
    private static LinkedList<Double> usedKeys = new LinkedList<Double>();
    private final static Double maxKeyValue = 100.0;
    private static int n = 30;
    private static Double p, q;

    // === PUBLIC ===

    public static Dictionary generate() {
        Dictionary dictionary = new Dictionary();
        _generate(dictionary, n);
        return dictionary;
    }

    public static void setN(int n) {
        Generator.n = n;
    }
    // === PRIVATE ===

    private static void _generate(Dictionary dictionary, int n) {
        p = Math.random();
        q = Math.random();
        dictionary.add(new Object(), getNewKey());
        if (yesOrNo(p)) dictionary.add(new Object(), getNewKey());
        if (yesOrNo(1 - p)) {
            dictionary.remove(getUsedKey());
            if (yesOrNo(q)) dictionary.remove(getUsedKey());
            if (yesOrNo(1 - p)) dictionary.add(new Object(), getNewKey());
        }
        if (n != 0)
            _generate(dictionary, n - 1);
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
        System.out.println(generate().getMap().size());
    }
}
