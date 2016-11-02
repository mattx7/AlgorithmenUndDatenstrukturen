package ad.page6_suchtbäume;

import org.jetbrains.annotations.NotNull;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by MattX7 on 31.10.2016.
 * Datastructure with a random amount of Elements.
 */
public class Dictionary<T> {
    private SortedMap<Double, T> map = new TreeMap<Double, T>();

    Dictionary() {
    }

    // === PUBLIC ===

    public void add(@NotNull T obj, @NotNull Double key) {
        map.put(key, obj);
    }

    public void remove(Double key) {
        map.remove(key);
    }

    public SortedMap<Double, T> getMap() {
        return map;
    }

    // === PRIVATE ===

}
