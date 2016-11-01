package edu.nyu.cs9053.homework7;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Bin<T> implements Iterable<T> {

    private final Collection<T> values;

    public Bin() {
        values = new ArrayList<>();
    }

    public void add(T item) {
        this.values.add(item);
    }

    public Iterator<T> iterator() {
        return values.iterator();
    }    

}