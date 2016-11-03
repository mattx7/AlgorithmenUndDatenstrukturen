package ad.page6_suchtbäume;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by MattX7 on 31.10.2016.
 * Datastructure with a random amount of Elements.
 */
public class OurDictionary<K, V> extends Dictionary<K, V> {
    private SortedMap<K, V> map = new TreeMap<K, V>();

    OurDictionary() {
    }

    /**
     * Returns the number of entries (distinct keys) in this dictionary.
     *
     * @return the number of keys in this dictionary.
     */
    public int size() {
        return map.size();
    }

    /**
     * Tests if this dictionary maps no keys to value. The general contract
     * for the <tt>isEmpty</tt> method is that the result is true if and only
     * if this dictionary contains no entries.
     *
     * @return <code>true</code> if this dictionary maps no keys to values;
     * <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Returns the value to which the key is mapped in this dictionary.
     * The general contract for the <tt>isEmpty</tt> method is that if this
     * dictionary contains an entry for the specified key, the associated
     * value is returned; otherwise, <tt>null</tt> is returned.
     *
     * @param key a key in this dictionary.
     *            <code>null</code> if the key is not mapped to any value in
     *            this dictionary.
     * @return the value to which the key is mapped in this dictionary;
     * @throws NullPointerException if the <tt>key</tt> is <tt>null</tt>.
     * @see Dictionary#put(Object, Object)
     */
    public V get(Object key) {
        return map.get(key);
    }

    /**
     * Maps the specified <code>key</code> to the specified
     * <code>value</code> in this dictionary. Neither the key nor the
     * value can be <code>null</code>.
     * <p>
     * If this dictionary already contains an entry for the specified
     * <tt>key</tt>, the value already in this dictionary for that
     * <tt>key</tt> is returned, after modifying the entry to contain the
     * new element. <p>If this dictionary does not already have an entry
     * for the specified <tt>key</tt>, an entry is created for the
     * specified <tt>key</tt> and <tt>value</tt>, and <tt>null</tt> is
     * returned.
     * <p>
     * The <code>value</code> can be retrieved by calling the
     * <code>get</code> method with a <code>key</code> that is equal to
     * the original <code>key</code>.
     *
     * @param key   the hashtable key.
     * @param value the value.
     * @return the previous value to which the <code>key</code> was mapped
     * in this dictionary, or <code>null</code> if the key did not
     * have a previous mapping.
     * @throws NullPointerException if the <code>key</code> or
     *                              <code>value</code> is <code>null</code>.
     * @see Object#equals(Object)
     * @see Dictionary#get(Object)
     */
    public V put(K key, V value) {
        map.put(key, value);
        return value;
    }

    /**
     * Removes the <code>key</code> (and its corresponding
     * <code>value</code>) from this dictionary. This method does nothing
     * if the <code>key</code> is not in this dictionary.
     *
     * @param key the key that needs to be removed.
     * @return the value to which the <code>key</code> had been mapped in this
     * dictionary, or <code>null</code> if the key did not have a
     * mapping.
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>.
     */
    public V remove(Object key) {
        return map.remove(key);
    }

    /**
     * @return
     */
    public int sortestPath() {
        return 0;
    }

    public int longestPath() {
        return 0;
    }

    public int avgPath() {
        return 0;
    }

    public Enumeration<K> keys() {
        return null;
    }

    public Enumeration<V> elements() {
        return null;
    }

}
