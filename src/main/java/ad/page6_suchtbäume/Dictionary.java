package ad.page6_suchtbäume;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by MattX7 on 31.10.2016.
 */
public class Dictionary {

    private int N, M;
    private LinkedList<Double> usedKeys = new LinkedList<Double>();
    private HashMap<Double, Object> map = new HashMap<Double, Object>();

    public Dictionary(@NotNull Integer n) {
        this.N = n;
        this.M = n;
    }

    // === PUBLIC ===

    public void startSomeSeriousShit(@NotNull Object obj) {
        insert(obj);
    }

    // === PRIVATE ===

    private void insert(@NotNull Object obj) {
        Double key = generateRandomKey();
        usedKeys.add(key);
        map.put(key, obj);
        Double p = Math.random();
        M--;
        if (M > 0) {
            if (yesOrNo(p)) insert("Cat" + p);
            if (yesOrNo(1 - p)) remove();
        }
        ;
    }

    private void remove() {
        map.remove(getRandomKey());
        Double q = Math.random();
        if (yesOrNo(q)) remove();
        if (yesOrNo(1 - q)) insert("Cat" + q);
    }

    private Boolean yesOrNo(Double x) {
        return x > 0.5;
    }

    private Double generateRandomKey() {
        return Math.random() * N;
    }

    private Double getRandomKey() {
        return usedKeys.get((int) (usedKeys.size() * Math.random()));
    }


    // === MAIN ===
    public static void main(String[] args) {
        Dictionary dict = new Dictionary(20);
        dict.startSomeSeriousShit("FirstCat");
    }
}
