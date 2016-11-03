package edu.nyu.cs9053.homework8;

import java.util.Collection;
import java.util.Map;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:27 PM
 */
public interface Multimap<K, V> extends Map<K, Collection<V>> {

    /**
     * @param key key into which to place {@code value}
     * @param value value to place into the collection mapped to {@code key}
     * @return true if the underlying collection changed as a result of calling this method
     */
    boolean putItem(K key, V value);

    /**
     * @param key key to which to retrieve the mapped values
     * @return the mapped values associated with {@code key}
     */
    Collection<V> getItems(K key);

}
